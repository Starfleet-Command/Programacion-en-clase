/*
     Program that implements the functionality of the cypher encode/decode HW
    Juan Francisco Gortarez Ricardez
    10/03/2020
*/

#include "rail_cypher.h"

char *encode(int rails, char *message)
{
    int len, index;
    len = strlen(message);
    index = 0;
    char *encodedMessage = calloc(rails * len, sizeof(char)); //Allocate memory for the intermediate encoded message
    char *result = malloc((len + 1) * sizeof(char));          //This will be the final message sent.

    if (!encodedMessage)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    // to find the direction
    bool dir_down = false;
    int row = 0, col = 0;

    for (size_t i = 0; i < len; i++)
    {
        if (row == 0 || row == (rails - 1))
        {
            dir_down = !dir_down; //Cypher changes direction if it's at the bottom or at the top
        }

        *(encodedMessage + (row * len) + col) = message[i];
        col++;
        if (dir_down == true)
        {
            row++; //Going down
        }
        else
            row--; //Going up
    }

    for (size_t s = 0; s < sizeof(char) * rails * len; s++)
    {

        if (*(encodedMessage + s) != 0) //If there are words it means that it is part of the message
        {
            *(result + index) = (*(encodedMessage + s)); //Index is necessary so that results don't overwrite each other
            index++;
        }
    }
    free(encodedMessage);
    free(message);

    return result;
}

char *decode(int rails, char *encodedMessage)
{
    int len, index;
    index = 0;
    len = strlen(encodedMessage);
    char *decodedMessage = calloc(rails * len, sizeof(char)); //Memory for intermediate decoding
    char *result = malloc(len * sizeof(char));                //Final message

    if (!decodedMessage || !result)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    bool dir_down = false;
    int row = 0, col = 0;

    for (size_t i = 0; i < len; i++) //Do the same thing as encode to mark the spots where the letters will fall
    {
        if (row == 0)
        {
            dir_down = true; //Cypher changes direction if it's at the bottom or at the top
        }
        else if (row == (rails - 1))
        {
            dir_down = false;
        }

        *(decodedMessage + (row * len) + col) = '*'; //Mark the spot where the message should be written
        col++;

        if (dir_down == true)
        {
            row++; //Going down
        }
        else
            row--; //Going up
    }

    for (size_t s = 0; s < rails; s++)
    {
        for (size_t r = 0; r < len; r++)
        {

            if (*(decodedMessage + (s * len) + r) == '*' && index < len) //Write the message only in the correct spot
            {
                printf("%c", *(encodedMessage + index));
                (*(decodedMessage + (s * len) + r)) = (*(encodedMessage + index)); //Re-write the message as if encoding to then read in zigzag later
                index++;
            }
        }
    }

    row = 0, col = 0, index = 0;
    for (size_t i = 0; i < len; i++) //Read in Zig-zag pattern
    {
        if (row == 0)
        {
            dir_down = true;
        }
        else if (row == rails - 1)
        {
            dir_down = false;
        }

        // place the marker
        if (*(decodedMessage + (row * len) + col) != '*')
        {
            *(result + index) = (*(decodedMessage + (row * len) + col));
            col++;
            index++;
        }

        // find the next row
        if (dir_down == true)
        {
            row++; //Going down
        }
        else
            row--; //Going up
    }

    free(encodedMessage);
    free(decodedMessage);

    return result;
}

char *readFile(char *filename)
{
    long textSize = 0;
    FILE *fp = NULL;

    fp = fopen(filename, "r"); //open file for reading
    if (!fp)
    {

        printf("Unable to open file '%s'\n", filename);
        exit(1);
    }
    while (fgetc(fp) != EOF)
    {
        textSize++;
    }
    fclose(fp);
    fp = fopen(filename, "r");

    char *fileData = malloc(textSize * sizeof(char)); //Memory allocation for the text inside the file
    fgets(fileData, textSize, fp);
    printf("%s", fileData);
    fclose(fp);
    return fileData; //I Have exactly 0 idea why this works without fgets or other reading... possibly because of overlapping addresses
}

char *writeFile(char *filename, int willDecode, int willEncode, char *message)
{
    FILE *fp = NULL;
    int filenameLen;
    filenameLen = strlen(filename);

    char *decode = NULL;
    decode = malloc(9 + filenameLen + 2);
    strcpy(decode, "decoded_");

    char *encode = NULL;
    encode = malloc(9 + filenameLen + 2);
    strcpy(encode, "encoded_");

    char *finalFilename = malloc(sizeof(char) * (maxRow + strlen(decode) + filenameLen));

    if (!finalFilename)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    if (willDecode == 1) //Write into decoded_filename.txt
    {
        finalFilename = strcat(decode, filename);
    }
    else if (willEncode == 1) //Write into encoded_filename.txt
    {
        finalFilename = strcat(encode, filename);
    }

    fp = fopen(finalFilename, "w+"); //Modify it or create it if it does not exist

    for (size_t i = 0; i < strlen(message); i++)
    {
        fputc(message[i], fp);
    }
    //After this it automatically prints a \n. This can cause issues in the translation.

    // fprintf(fp, "\n");

    free(message);
    /*
    free(encode);
    free(decode);
    */

    return finalFilename;
}