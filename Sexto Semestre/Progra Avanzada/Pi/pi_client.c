/*
    Client program to get the value of PI
    This program connects to the server using sockets

    Gilberto Echeverria
    gilecheverria@yahoo.com
    21/10/2018
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <poll.h>
// Sockets libraries
#include <netdb.h>
#include <arpa/inet.h>
// Custom libraries
#include "sockets.h"
#include "fatal_error.h"

#define BUFFER_SIZE 1024

///// FUNCTION DECLARATIONS
void usage(char *program);
void requestPI(int connection_fd);
sigset_t setupMask();
void setupHandler();
void onInterrupt(int signal);

//GLOBAL VARIABLE
int isInterrupted;

///// MAIN FUNCTION
int main(int argc, char *argv[])
{
    int connection_fd;
    isInterrupted = 0;

    printf("\n=== CLIENT FOR COMPUTING THE VALUE OF pi ===\n");

    // Check the correct arguments
    if (argc != 3)
    {
        usage(argv[0]);
    }

    setupHandler();
    setupMask();

    // Start the server
    connection_fd = connectSocket(argv[1], argv[2]);
    // Listen for connections from the clients
    requestPI(connection_fd);
    // Close the socket
    close(connection_fd);

    return 0;
}

///// FUNCTION DEFINITIONS

/*
    Explanation to the user of the parameters required to run the program
*/
void usage(char *program)
{
    printf("Usage:\n");
    printf("\t%s {server_address} {port_number}\n", program);
    exit(EXIT_FAILURE);
}

void onInterrupt(int signal)
{
    isInterrupted = 1;

    //IF you want to use program data or communicate sth you need to use global variables.
}

sigset_t setupMask()
{
    sigset_t new_set;
    sigset_t old_set;

    if (sigfillset(&new_set) == -1)
    {
        perror("Error in filled set declaration");
        exit(1);
    }

    if (sigdelset(&new_set, SIGINT) == -1)
    {
        perror("Error in removing SIGINT from blocked");
        exit(1);
    }

    if (sigprocmask(SIG_BLOCK, &new_set, &old_set) == -1)
    {
        perror("Error in sigprocmask");
        exit(1);
    }
    return old_set;
}

void setupHandler()
{
    struct sigaction action;

    //clean
    bzero(&action, sizeof(action));

    //State: ignore a signal
    action.sa_handler = onInterrupt;

    //Sig fill
    sigfillset(&action.sa_mask);

    //Set the handler
    if (sigaction(SIGINT, &action, NULL) == -1)
    {
        perror("Error in setup handler");
    }
}

void requestPI(int connection_fd)
{
    char buffer[BUFFER_SIZE];
    unsigned long int iterations;
    double result;

    struct pollfd poll_list[1];
    poll_list[0].fd = connection_fd;
    poll_list[0].events = POLLIN;
    int retval;

    printf("Enter the number of iterations for PI: ");
    scanf("%lu", &iterations);

    // Prepare the response to the client
    sprintf(buffer, "%lu", iterations);
    // SEND
    // Send the response
    sendString(connection_fd, buffer);

    while (42)
    {
        retval = poll(poll_list, 1, TIMEOUT); //Check for incoming messages.

        if (retval > 0) //If message found...
        {

            if (poll_list[0].revents & POLLIN)
            {
                recvString(connection_fd, buffer, BUFFER_SIZE); //Receive result from server
                sscanf(buffer, "%lu %lf", &iterations, &result);
                // Print the result
                printf("With %lu iterations, The value for PI is: %.20lf\n", iterations, result);
                break;
            }
        }

        if (isInterrupted) //If client is interrupted, send signal to server
        {
            sprintf(buffer, "%d", 1); //1 means it has been interrupted
            sendString(connection_fd, buffer);
        }
    }
}
