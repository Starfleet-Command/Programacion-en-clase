/*
Functions to read, convert, rotate and write a ppm image

Juan Francisco Gortarez Ricardez A01021926
20/02/2020
*/

#include "ConvertPPM.h"

ImageData *readImage(char *filename, int *maxPix)
{
    char buff[BUFFER_SIZE];
    ImageData *img = NULL;
    FILE *fp = NULL;
    int c, rgb_comp_color;

    img = (ImageData *)malloc(sizeof(ImageData)); //create the struct that will hold the image
    if (!img)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    fp = fopen(filename, "rb+"); //open PPM file for reading
    if (!fp)
    {

        printf("Unable to open file '%s'\n", filename);
        exit(1);
    }

    fgets(buff, sizeof(buff), fp); //Get the first line

    if (buff[0] != 'P' || ((buff[1] != '6') & (buff[1] != '3'))) //A ppm image has the header format "P6" if binary and "P3" if not
    {
        printf("Invalid image (must be 'P6' or 'P3')\n");
        exit(1);
    }

    if (buff[1] == '6')
    {
        img->isBinary = 1;
    }
    else //If the image isn't binary, close it and open it again in non-binary mode
    {
        img->isBinary = 0;
        fclose(fp);
        fp = fopen(filename, "r+");
        fgets(buff, sizeof(buff), fp);
    }

    c = getc(fp); //Eliminate any comments in the image format
    while (c == '#')
    {
        while (getc(fp) != '\n')
            ;
        c = getc(fp);
    }
    ungetc(c, fp);

    fscanf(fp, "%d %d", &img->row, &img->col); //look for the image data and assign it to the struct

    fscanf(fp, "%d", &rgb_comp_color); //get the RGB component values

    if (rgb_comp_color != MAX_PIX_VAL) //Ensure that RGB depth is 255
    {
        *maxPix = rgb_comp_color;
    }
    else
    {
        *maxPix = MAX_PIX_VAL;
    }

    while (fgetc(fp) != '\n')
        ;
    //memory allocation for pixel data
    img->data = (Pixel *)malloc(3 * img->row * img->col * sizeof(Pixel));

    if (!img)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }
    //read pixel data from file
    if (img->isBinary == 1)
    {
        if (fread(img->data, 3 * img->row, img->col, fp) != img->col)
        {
            printf("Error loading image\n");
            exit(1);
        }
    }

    else //Read data in ascii from file
    {
        for (size_t c = 0; c < 3 * img->row * img->col; c = c + 3)
        {
            fscanf(fp, "%d", &(img->data[c].red));
            fscanf(fp, "%d", &(img->data[c].green));
            fscanf(fp, "%d", &(img->data[c].blue));
        }
    }
    fclose(fp);
    return img;
}

void writeImage(char *filename, ImageData *img, int *maxPix)
{
    FILE *fp = NULL;

    if (img->isBinary == 1)
    {
        fp = fopen(filename, "wb+"); //Open file in "binary write mode"
    }
    else
    {
        fp = fopen(filename, "w+"); //If file is not binary, open in normal write mode
    }

    if (!fp)
    {
        printf("Unable to open file '%s'\n", filename);
        exit(1);
    }

    if (img->isBinary == 1) //The header for binary and non-binary ppms is different
    {
        fprintf(fp, "P6\n"); //write the binary header file
    }
    else
        fprintf(fp, "P3\n"); //write the non-binary header file

    //image size
    fprintf(fp, "%d %d\n", img->row, img->col);

    // rgb component depth
    fprintf(fp, "%d\n", *maxPix);

    // pixel data
    if (img->isBinary == 1)
    {
        fwrite(img->data, 3 * img->row, img->col, fp);
    }

    else
    {
        int lineManager = 0;

        for (size_t c = 0; c < (3 * img->row) * img->col; c = c + 3) //Print in Ascii
        {
            lineManager = lineManager + 3;
            fprintf(fp, "%d %d %d ", img->data[c].red, img->data[c].green, img->data[c].blue);
            if (lineManager >= img->col * 3) //Check if the maximum image width has been reached in order to create a newline
            {
                fprintf(fp, "\n");
                lineManager = 0;
            }
        }
    }

    fclose(fp);
}

ImageData *rotateImage(ImageData *img, int dir, int numRot)
{
    int maxRow, maxCol;
    maxRow = img->row;
    maxCol = img->col;
    printf("%d", maxRow);
    printf("%d", maxCol);
    Pixel img_array[maxCol][maxRow];
    for (int g = 0; g < numRot * dir; g++) //Rotate the image according to the number and direction of rotations
    {
        int counter = 0;
        int transformCounter = 0;

        for (int i = 0; i < maxCol; i++) //Transform the image to a 2d array of pixels
        {
            for (int j = 0; j < maxRow; j++)
            {

                img_array[i][j].red = img->data[counter].red;
                img_array[i][j].green = img->data[counter].green;

                img_array[i][j].blue = img->data[counter].blue;
                counter++;
            }
        }

        Pixel rotated_array[maxRow][maxCol];

        for (int i = 0; i < maxCol; i++) //Rotate the array of pixels
        {
            for (int j = 0; j < maxRow; j++)
            {
                rotated_array[j][maxCol - i - 1] = img_array[i][j];
            }
        }

        for (int i = 0; i < maxRow; i++) //Transform the array back to an image
        {
            for (int j = 0; j < maxCol; j++)
            {

                img->data[transformCounter].red = rotated_array[i][j].red;

                img->data[transformCounter].green = rotated_array[i][j].green;

                img->data[transformCounter].blue = rotated_array[i][j].blue;
                transformCounter++;
            }
        }
    }
    return img;
}

ImageData *applyNegative(ImageData *img, int *maxPix)
{
    int i;
    for (i = 0; i < 3 * img->row * img->col; i++) //make the pixels into their negatives
    {

        img->data[i].red = *maxPix - img->data[i].red;
        img->data[i].green = *maxPix - img->data[i].green;
        img->data[i].blue = *maxPix - img->data[i].blue;
    }
    return img;
}
