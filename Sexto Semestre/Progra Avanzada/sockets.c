/*
    Program for a simple chat server
    Can only connect with one client at a time
    Gilberto Echeverria
    gilecheverria@yahoo.com
    23/02/2017
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>

// Include libraries for sockets
#include <netdb.h>
#include <arpa/inet.h>

#define MAX_QUEUE 5
#define BUFFER_SIZE 1024

void usage(char *program);
int startServer(char *port);
void waitForConnections(int server_fd);
void communicationLoop(int connection_fd);

int main(int argc, char *argv[])
{
    int server_fd;

    printf("\n=== SERVER PROGRAM ===\n");

    if (argc != 2)
        usage(argv[0]);

    // Use the first argument as the port number
    server_fd = startServer(argv[1]);
    // Stand by to receive connections from the clients
    waitForConnections(server_fd);

    printf("Closing the server socket\n");
    // Close the socket
    close(server_fd);

    return 0;
}

// Show the user how to run this program
void usage(char *program)
{
    printf("Usage:\n%s {port_number}\n", program);
    exit(EXIT_FAILURE);
}

// Initialize the server to be ready for connections
int startServer(char *port)
{
    struct addrinfo hints;
    struct addrinfo *server_info = NULL;
    int server_fd;

    // Prepare the information to determine the local address
    bzero(&hints, sizeof(hints)); // Clear all fields

    hints.ai_family = AF_INET; // Use internet sockets with IPv4

    hints.ai_socktype = SOCK_STREAM; // Use connected sockets

    hints.ai_flags = AI_PASSIVE; // Determine the ip of this machine automatically

    ///// GETADDRINFO
    // Get the actual address of this computer
    if (getaddrinfo(NULL, port, &hints, &server_info) == -1)
    {
        perror("Error at getting the address info");
        exit(1);
    }

    ///// SOCKET
    // Use the information obtained by getaddrinfo to create a socket
    server_fd = socket(server_info->ai_family, server_info->ai_socktype, server_info->ai_protocol);

    if (server_fd == -1)
    {
        perror("Error in socket creation");
        close(server_fd);
        exit(1);
    }

    // Reuse socket port (Optional)
    // Allow using the same port immediately, even if the previous server did not close correctly
    int allow = 1;
    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR, &allow, sizeof(allow)) == -1)
    {
        perror("Error setting socket options");
        close(server_fd);
        exit(1);
    }

    ///// BIND
    // Connect with the desired port
    if (bind(server_fd, server_info->ai_addr, server_info->ai_addrlen) == -1)
    {
        perror("Binding error");
        close(server_fd);
        exit(1);
    }
    // Release the memory of the list of addrinfo
    freeaddrinfo(server_info);

    ///// LISTEN
    // Prepare for connections
    if (listen(server_fd, MAX_QUEUE) == -1)
    {
        perror("Error listening");
        close(server_fd);
        exit(1);
    }
    // printf("Server ready and waiting!\n");

    return server_fd;
}

// Stand by for connections by the clients
void waitForConnections(int server_fd)
{
    struct sockaddr_in client_address;
    socklen_t client_address_size;
    char client_presentation[INET_ADDRSTRLEN];
    int connection_fd;

    while (42)
    {
        ///// ACCEPT
        // Receive incomming connections
        // Get the size of the structure where the address of the client will be stored
        client_address_size = sizeof(client_address);
        connection_fd = accept(server_fd, (struct sockaddr *)&client_address, &client_address_size);
        char client_presentation[INET_ADDRSTRLEN];
        __pid_t pid;

        pid = fork();

        if (pid < 0) //Throw an error if child creation failed (Honey, are you infertile?)
        {
            fprintf(stderr, "Fork Failed");
            exit(1);
        }

        if (pid == 0) //If the process reading this is a child process
        {
            close(server_fd);
            inet_ntop(client_address.sin_family, &client_address.sin_addr, client_presentation, sizeof(client_presentation));
            printf("Received connection from %s: %d \n", client_presentation, client_address.sin_port);

            if (connection_fd == -1)
            {
                perror("Error on accept");
                close(connection_fd);
            }
            // Receive the data from the client and open a new socket connection

            // Identify the client (Optional)
            // Get the ip address from the structure filled by accept

            // Establish the communication
            communicationLoop(connection_fd);
            exit(0);
        }

        else
        {
            close(connection_fd);
        }
    }
}

// Do the actual receiving and sending of data
void communicationLoop(int connection_fd)
{
    char buffer[BUFFER_SIZE];
    int message_counter = 0;
    int chars_read;

    while (42)
    {

        // Clear the buffer
        bzero(buffer, BUFFER_SIZE);

        ///// RECV
        // Read the request from the client
        chars_read = recv(connection_fd, buffer, BUFFER_SIZE, 0);
        // Error when reading
        if (chars_read == -1)
        {
            perror("ERROR: recv");
            exit(EXIT_FAILURE);
        }
        // Connection finished
        if (chars_read == 0)
        {
            printf("Client disconnected\n");
            break;
        }

        message_counter++;
        printf("The client message #%d: %s\n", message_counter, buffer);

        // Pretend to take some time to attend the request
        //sleep(3);

        // Preapare a reply message
        sprintf(buffer, "Reply to message #%d\n", message_counter);
        ///// SEND
        // Send a reply to the client
        send(connection_fd, buffer, strlen(buffer) + 1, 0);
    }
}