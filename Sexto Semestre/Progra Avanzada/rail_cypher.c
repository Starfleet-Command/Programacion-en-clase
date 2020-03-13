/*
     Program that implements the functionality of the cypher encode/decode HW
    Juan Francisco Gortarez Ricardez
    10/03/2020
*/

#include "rail_cypher.h"

char *encode(int rails, char *message)
{
    int len;
    len = strlen(message);
    char *encodedMessage = calloc(rails * len, sizeof(char)); //Allocate memory for the encoded message

    if (!encodedMessage)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    // to find the direction
    bool dir_down = false;
    int row = 0, col = 0;

    for (int i = 0; i < len; i++)
    {
        if (row == 0 || row == (rails - 1))
        {
            dir_down = !dir_down; //Cypher changes direction if it's at the bottom or at the top
        }
        col++;
        *(encodedMessage + (i * len) + col) = message[i];

        if (dir_down == true)
        {
            row++; //Going down
        }
        else
            row--; //Going up
    }

    return encodedMessage;
}

char *decode(int rails, char *encodedMessage)
{
    int count, j, len, i;
    char *decodedMessage = malloc(maxRow * sizeof(char));

    if (!decodedMessage)
    {
        printf("Unable to allocate memory\n");
        exit(1);
    }

    len = strlen(encodedMessage);
    count = 0;
    j = 0;
    while (j < len) //Do everything as if it were encoding, only backwards
    {
        if (count % 2 == 0)
        {
            for (i = 0; i < rails; i++)
            {
                decodedMessage[j] = *(encodedMessage + i * maxRow + j);
                j++;
            }
        }
        else
        {

            for (i = rails - 2; i > 0; i--)
            {
                decodedMessage[j] = *(encodedMessage + i * maxRow + j);
                j++;
            }
        }

        count++;
    }
    return decodedMessage;
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

    char *fileData = malloc(textSize * sizeof(char));

    fgets(fileData, textSize, fp);

    return fileData;
}

char *writeFile(char *filename, int willDecode, int willEncode, char *message)
{
    FILE *fp = NULL;
    char decode[] = "decoded_";
    char encode[] = "encoded_";
    char *finalFilename = malloc(sizeof(char) * maxRow);

    if (willDecode == 1) //Write into decoded_filename.txt
    {
        finalFilename = strcat(decode, filename);
        fp = fopen(decode, "w+");
    }
    else if (willEncode == 1)
    {
        finalFilename = strcat(encode, filename);
        fp = fopen(encode, "w+");
    }

    for (size_t i = 0; i < strlen(message); i++)
    {
        fputc(message[i], fp);
    }
    fprintf(fp, "\n");

    free(message);
    return finalFilename;
}