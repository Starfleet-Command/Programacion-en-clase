/*
    Driver program to test the functionality of the cypher encode/decode
    Juan Francisco Gortarez Ricardez
    10/03/2020
*/

#include "rail_cypher.h"

int main(int argc, char *argv[])
{
    int options, willEncode, willDecode, rails;
    char inFilename[50];
    char *outFilename = NULL;
    int pipe1[2];
    char *message = NULL;

    if (pipe(pipe1) == -1) //Make a pipe and throw an error if it fails
    {
        fprintf(stderr, "Pipe Failed");
        return 1;
    }

    while ((options = getopt(argc, argv, "edf:r:")) != -1)
    {
        switch (options)
        {
        case 'e':

            willDecode = 0;
            willEncode = 1;
            break;

        case 'd':

            willDecode = 1;
            willEncode = 0;
            break;

        case 'f':
            strcpy(inFilename, optarg);
            break;

        case 'r':
            rails = atoi(optarg);
            break;

        case '?': //If an incorrect option is sent, getopt returns a ?
            printf("unknown option: %c\n", optopt);
            exit(1);
            break;
        default:
            printf("Usage: ./{name} -e(if encoding) -d (if decoding) -f {'filename'} -r {no. of rails}");
            break;
        }
    }
    __pid_t pid;
    pid = fork(); //Create a new child

    if (pid < 0) //Throw an error if child creation failed
    {
        fprintf(stderr, "Fork Failed");
        return 1;
    }

    if (pid == 0) //If the process reading this is a child process
    {
        message = readFile(inFilename); //Varying parameters depending on if it's encoding or decoding
        if (willEncode == 1)
        {
            message = encode(rails, message);
            outFilename = writeFile(inFilename, 0, 1, message);
        }
        else if (willDecode == 1)
        {
            message = decode(rails, message);
            outFilename = writeFile(inFilename, 1, 0, message);
        }
        close(pipe1[0]);
        write(pipe1[1], message, strlen(message)); //Close reading end of pipe, write on writing end
        close(pipe1[1]);                           //Close writing end
    }
    else
    {
        wait(NULL);
        close(pipe1[1]);
        read(pipe1[0], outFilename, sizeof(char) * maxRow);
        printf("The processed file is located at %s", outFilename);
        free(outFilename);
    }

    return 0;
}
