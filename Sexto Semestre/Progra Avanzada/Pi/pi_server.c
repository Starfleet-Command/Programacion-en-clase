/*
    Server program to compute the value of PI
    This program calls the library function 'get_pi'
    It will create child processes to attend requests
    It receives connections using sockets

    Gilberto Echeverria
    gilecheverria@yahoo.com
    21/10/2018
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
// Sockets libraries
#include <netdb.h>
#include <arpa/inet.h>
#include <signal.h>
#include <poll.h>
// Custom libraries
#include "sockets.h"
#include "fatal_error.h"

#define BUFFER_SIZE 1024
#define MAX_QUEUE 5

///// FUNCTION DECLARATIONS
void usage(char *program);
void waitForConnections(int server_fd);
void attendRequest(int client_fd);
void setupHandler();
void onInterrupt(int signal);
sigset_t setupMask();

///GLOBAL VARIABLE
int isInterrupted;

///// MAIN FUNCTION
int main(int argc, char *argv[])
{
    int server_fd;
    isInterrupted = 0;

    printf("\n=== SERVER FOR COMPUTING THE VALUE OF pi ===\n");

    // Check the correct arguments
    if (argc != 2)
    {
        usage(argv[0]);
    }

    // Show the IPs assigned to this computer
    printLocalIPs();
    setupHandler();
    setupMask();

    // Start the server
    server_fd = initServer(argv[1], MAX_QUEUE);
    // Listen for connections from the clients
    waitForConnections(server_fd);
    // Close the socket
    close(server_fd);

    return 0;
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

void onInterrupt(int signal)
{

    isInterrupted = 1;
    //IF you want to use program data or communicate sth you need to use global variables.
}

///// FUNCTION DEFINITIONS

/*
    Explanation to the user of the parameters required to run the program
*/
void usage(char *program)
{
    printf("Usage:\n");
    printf("\t%s {port_number}\n", program);
    exit(EXIT_FAILURE);
}

/*
    Main loop to wait for incomming connections
*/
void waitForConnections(int server_fd)
{
    struct sockaddr_in client_address;
    socklen_t client_address_size;
    char client_presentation[INET_ADDRSTRLEN];
    int client_fd;
    pid_t new_pid;

    struct pollfd poll_list[1];
    poll_list[0].fd = server_fd;
    poll_list[0].events = POLLIN;

    int retval = 0;

    // Get the size of the structure to store client information
    client_address_size = sizeof client_address;

    while (!isInterrupted)
    {

        // ACCEPT
        // Wait for a client connection

        retval = poll(poll_list, 1, TIMEOUT);
        if (retval > 0)
        {
            if (poll_list[0].revents & POLLIN)
            {
                client_fd = accept(server_fd, (struct sockaddr *)&client_address, &client_address_size);
                if (client_fd == -1)
                {
                    fatalError("accept");
                }
                // Get the data from the client
                inet_ntop(client_address.sin_family, &client_address.sin_addr, client_presentation, sizeof client_presentation);
                printf("Received incomming connection from %s on port %d\n", client_presentation, client_address.sin_port);

                // FORK
                // Create a new child process to deal with the client
                new_pid = fork();
                // Parent
                if (new_pid > 0)
                {
                    // Close the new socket
                    close(client_fd);
                }
                else if (new_pid == 0)
                {
                    // Close the main server socket to avoid interfering with the parent
                    close(server_fd);
                    printf("Child process %d dealing with client\n", getpid());
                    // Deal with the client
                    attendRequest(client_fd);
                    // Close the new socket
                    close(client_fd);
                    // Terminate the child process
                    exit(EXIT_SUCCESS);
                }
                else
                {
                    fatalError("fork");
                }
            }
        }
    }
}

/*
    Hear the request from the client and send an answer
*/
void attendRequest(int client_fd)
{
    char buffer[BUFFER_SIZE];
    unsigned long int iterations;
    int clientInterrupt = 0;
    struct pollfd poll_list[1];
    poll_list[0].fd = client_fd;
    poll_list[0].events = POLLIN;

    int retval;

    // RECV
    // Receive the request
    recvString(client_fd, buffer, BUFFER_SIZE);
    sscanf(buffer, "%lu", &iterations);

    printf(" > Got request from client with iterations=%lu\n", iterations);

    //Compute value of pi
    double result = 4;
    int sign = -1;
    unsigned long int divisor = 3;
    unsigned long int counter = 0;

    for (counter = 0; counter < iterations; counter++)
    {
        result += sign * (4.0 / divisor);
        sign *= -1;
        divisor += 2;

        if (isInterrupted == 0)
        {

            retval = poll(poll_list, 1, TIMEOUT); //Poll to check for incoming messages

            if (retval > 0) //If a message has been found
            {

                if (poll_list[0].revents & POLLIN)
                {
                    recvString(client_fd, buffer, BUFFER_SIZE); //Receive from client if it has been interrupted
                    sscanf(buffer, "%d", &clientInterrupt);
                    if (clientInterrupt) //If client has been interrupted, server signals to stop.
                    {
                        isInterrupted = 1;
                        printf("Interrupted by client!\n");
                        break;
                    }
                }
            }
        }
        else //If client has interrupted or server interrupts itself,stop the iterations
            break;
    }

    printf(" > Sending PI=%.20lf\n", result);
    // Prepare the response to the client
    sprintf(buffer, "%lu %.20lf", counter, result);
    // SEND
    // Send the response
    sendString(client_fd, buffer);
}
