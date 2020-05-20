/*
    Driver program to test the functionality of the cypher encode/decode
    Juan Francisco Gortarez Ricardez
    (I apologize for any bad children-related jokes in the comments)
    10/03/2020
*/

#include "rail_cypher.h"

int main(int argc, char *argv[])
{
    int options, willEncode, willDecode, rails, stat;
    char inFilename[maxRow];
    char receivedFilename[maxRow];
    char *dataToChild = malloc(sizeof(char) * maxRow);
    char *outFilename = NULL;
    int pipe1[2];
    int PtCPipe[2];
    char *message = NULL;

    if (pipe(pipe1) == -1) //Make a pipe and throw an error if it fails
    {
        fprintf(stderr, "Pipe Failed");
        return 1;
    }

    if (pipe(PtCPipe) == -1) //Make a pipe and throw an error if it fails
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
            printf("Usage: ./{name} -e(if encoding) -d (if decoding) -f {'filename'} -r {no. of rails}");
            exit(1);
            break;
        }
    }
    __pid_t pid;
    pid = fork(); //Create a new child (The miracle of childbirth)

    if (pid < 0) //Throw an error if child creation failed (Honey, are you infertile?)
    {
        fprintf(stderr, "Fork Failed");
        return 1;
    }

    if (pid == 0) //If the process reading this is a child process
    {
        char *dataFromParent = malloc(maxRow * sizeof(char));
        close(PtCPipe[1]);
        read(PtCPipe[0], dataFromParent, maxRow);
        close(PtCPipe[0]);

        sscanf(dataFromParent, "%c %d %d %d", inFilename, &rails, &willEncode, &willDecode); //Technically I could not do the fork, but it's the principle of the matter

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
        write(pipe1[1], outFilename, (strlen(outFilename))); //Close reading end of pipe, write on writing end
        close(pipe1[1]);                                     //Close writing end
        free(outFilename);                                   //Freeing the memory allocated at the start
        free(dataFromParent);
        free(message);
        exit(0);
    }
    else //Code executed by parent (No timmy, this is for adults only)
    {
        sprintf(dataToChild, "%s %c %c %c", inFilename, rails, willEncode, willDecode);
        close(PtCPipe[0]);
        write(PtCPipe[1], dataToChild, sizeof(dataToChild));
        close(PtCPipe[1]);

        wait(&stat);           //Wait for child to finish executing (Soccer Mom Waiting for Son)
        if (WIFSIGNALED(stat)) //Error handling if something happens to the child (Child protection Services)
        {
            psignal(WTERMSIG(stat), "Crashed. Error"); //Honey, I aborted/killed/terminated the child.
            exit(1);                                   //*runs away from police*
        }

        close(pipe1[1]);
        read(pipe1[0], receivedFilename, sizeof(receivedFilename)); //Read the filename from the pipe that has been written by the child
        close(pipe1[0]);
        printf("The processed file is located at %s", receivedFilename);
        free(dataToChild);
    }
    return 0;
}
