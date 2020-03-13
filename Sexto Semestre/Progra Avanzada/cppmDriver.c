/*
Driver and demonstration of the functions to read, convert and write a ppm
Juan Francisco Gortarez
21/02/2020
*/

#include "ConvertPPM.h"

int main(int argc, char *argv[])
{

    //char *inFilename, *outFilename;
    char inFilename[50];
    char outFilename[50];
    char cw[] = "CW";
    char ccw[] = "CCW";
    ImageData *image = NULL;
    int options, isNegative, dirRotation, noRotations;
    int maxPix;
    isNegative = 0;
    dirRotation = 0;
    noRotations = 0;

    while ((options = getopt(argc, argv, "i:o:nr:")) != -1) //process the options from the console input
    {
        switch (options)
        {
        case 'i':
            strcpy(inFilename, optarg);
            break;

        case 'o':
            strcpy(outFilename, optarg);
            break;
        case 'n':
            isNegative = 1;
            break;
        case 'r':
            noRotations++;
            if (strncmp(optarg, cw, sizeof(cw)) == 0)
            {
                dirRotation = 1; //CW rotation is assigned a value of 1. CCW is assigned a 3 (because of the number of rotations each will take )
            }
            else if (strncmp(optarg, ccw, sizeof(ccw)) == 0)
            {
                dirRotation = dirRotation + 3;
            }
            break;
        case '?': //If an incorrect option is sent, getopt returns a ?
            printf("unknown option: %c\n", optopt);
            printf("Usage: ./{name} -i {input file with ''} -o {output file with ''} [Optional] -n -r {'CW'/'CCW'}");
            exit(1);
            break;
        }
    }

    image = readImage(inFilename, &maxPix);
    image = rotateImage(image, dirRotation, noRotations);
    if (isNegative == 1)
    {
        image = applyNegative(image, &maxPix);
    }
    writeImage(outFilename, image, &maxPix);
    free(image);
    return 0;
}