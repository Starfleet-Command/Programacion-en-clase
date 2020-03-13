/*
Header file for the functions required for the PPM homework
Juan Francisco Gortarez 
20/02/2020
*/

#define BUFFER_SIZE 32
#define MAX_PIX_VAL 255

typedef struct
{
    unsigned char red;
    unsigned char green;
    unsigned char blue;
} Pixel;

typedef struct
{
    int row;
    int col;
    int isBinary;
    Pixel *data;

} ImageData;

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <getopt.h>
#include <unistd.h>

ImageData *readImage(char *filename, int *maxPix);

void writeImage(char *filename, ImageData *img, int *maxPix);

ImageData *rotateImage(ImageData *img, int dir, int numRot);

ImageData *applyNegative(ImageData *img, int *maxPix);
