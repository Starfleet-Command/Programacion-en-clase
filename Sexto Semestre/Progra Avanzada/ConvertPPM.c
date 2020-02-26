/*
Functions to read, convert, rotate and write a ppm image

Juan Francisco Gortarez Ricardez A01021926
20/02/2020
*/

#include "ConvertPPM.h"
int isBinary;

ImageData *readImage(char *filename)
{
    char buff[BUFFER_SIZE];
    ImageData *img;
    FILE *fp;
    int c, rgb_comp_color;

    fp = fopen(filename, "rb+"); //open PPM file for reading
    if (!fp)
    {

        printf("Unable to open file '%s'\n", filename);
        exit(1);
    }

    fgets(buff, sizeof(buff), fp); //Get the first line

    if (buff[0] != 'P' || (buff[1] != '6' & buff[1] != '3')) //A ppm image has the header format "P6" if binary and "P3" if not
    {
        printf("Invalid image (must be 'P6' or 'P3')\n");
        exit(1);
    }

    if (buff[1] == '6')
    {
        isBinary = 1;
    }
    else //If the image isn't binary, close it and open it again in non-binary mode
    {
        isBinary = 0;
        fclose(fp);
        fp = fopen(filename, "r+");
        fgets(buff, sizeof(buff), fp);
    }
    printf("VALUE OF ISBINARY: %d", isBinary);

    img = (ImageData *)malloc(sizeof(ImageData)); //create the struct that will hold the image
    if (!img)
    {
        printf("Unable to allocate memory\n");
        exit(1);
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
        printf("Component and depth do not match\n");
        exit(1);
    }

    while (fgetc(fp) != '\n')
        ;
    //memory allocation for pixel data
    img->data = (Pixel *)malloc(img->row * img->col * sizeof(Pixel));

    if (!img)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    //read pixel data from file
    if (isBinary == 1)
    {
        if (fread(img->data, 3 * img->row, img->col, fp) != img->col)
        {
            printf("Error loading image\n");
            exit(1);
        }
    }

    else
    {

        for (size_t c = 0; c < img->row * img->col; c = c + 3)
        {
            fscanf(fp, "%d", &(img->data[c].red));
            fscanf(fp, "%d", &(img->data[c].green));
            fscanf(fp, "%d", &(img->data[c].blue));
        }
    }

    fclose(fp);
    return img;
}

void writeImage(char *filename, ImageData *img, int isNegative)
{
    FILE *fp;

    if (isBinary == 1)
    {
        fp = fopen(filename, "wb+"); //Open file in "binary write mode"
    }
    else
        fp = fopen(filename, "w+"); //If file is not binary, open in normal write mode

    if (!fp)
    {
        printf("Unable to open file '%s'\n", filename);
        exit(1);
    }

    if (isNegative == 1)
    {
        int i;
        for (i = 0; i < img->row * img->col; i++) //make the pixels into their negatives
        {

            img->data[i].red = MAX_PIX_VAL - img->data[i].red;
            img->data[i].green = MAX_PIX_VAL - img->data[i].green;
            img->data[i].blue = MAX_PIX_VAL - img->data[i].blue;
        }
    }

    if (isBinary == 1) //The header for binary and non-binary ppms is different
    {
        fprintf(fp, "P6\n"); //write the binary header file
    }
    else
        fprintf(fp, "P3\n"); //write the non-binary header file

    //image size
    fprintf(fp, "%d %d\n", img->row, img->col);

    // rgb component depth
    fprintf(fp, "%d\n", MAX_PIX_VAL);

    // pixel data
    if (isBinary == 1)
    {
        fwrite(img->data, 3 * img->row, img->col, fp);
    }

    else
    {

        for (size_t c = 0; c < img->row * img->col; c = c + 3)
        {
            fputc(img->data[c].red, fp);
            fputs(" ", fp);
            fputc(img->data[c].green, fp);
            fputs(" ", fp);
            fputc(img->data[c].blue, fp);
            fputs(" ", fp);
        }
    }

    fclose(fp);
}

ImageData *rotateImage(ImageData *img, int dir, int numRot)
{
    int row, col, maxRow, maxCol;
    row = 0;
    col = 0;
    maxRow = img->row;
    maxCol = img->col;
    Pixel prev, curr;

    while (row < maxRow && col < maxCol) //Save the first element of next row (which will replace current row)
    {
    }

    for (int i = col; i < maxCol; i++) //Transpose elements horizontally
    {
        curr = *(img + (i * row) + col)->data;
        *(img + row + col)->data = prev;
        prev = curr;
    }
    row++;

    return img;
}
