/*
Driver and demonstration of the functions to read, convert and write a ppm
Juan Francisco Gortarez
21/02/2020
*/

#include "convertPPM.h"

int main(int argc, char const *argv[])
{

    //char *inFilename, *outFilename;
    char inFilename[50];
    char outFilename[50];
    char cw[] = "CW";
    char ccw[] = "CCW";
    ImageData *image;
    int options, isNegative, dirRotation, noRotations;
    isNegative = 0;

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
            if (strncmp(optarg, cw, sizeof(optarg)) == 0)
            {
                dirRotation++; //CW rotation is assigned a value of 1. CCW is assigned -1
            }
            else if (strncmp(optarg, ccw, sizeof(optarg)) == 0)
            {
                dirRotation--;
            }
            break;
        case '?': //If an incorrect option is sent, getopt returns a ?
            printf("unknown option: %c\n", optopt);
            break;

        default:
            break;
        }
    }
    image = readImage(inFilename);
    // image = rotateImage(image, dirRotation, noRotations);
    writeImage(outFilename, image, isNegative);
    return 0;
}