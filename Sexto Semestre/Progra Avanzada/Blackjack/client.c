/*
    Client program for playing Blackjack
    Juan Francisco Gortarez A01021926
    15/04/2020
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#include <netdb.h>

#define BUFFER_SIZE 1024

void usage(char *program);
int connectToServer(char *address, char *port);
void communicationLoop(int connection_fd);
void receive(int connection_fd, char *buffer);

int main(int argc, char *argv[])
{
    int connection_fd;

    printf("\n=== CLIENT PROGRAM ===\n");

    if (argc != 3)
        usage(argv[0]);

    // Use the first argument as the host, and the second as the port to connect to
    connection_fd = connectToServer(argv[1], argv[2]);

    // Establish the communication
    communicationLoop(connection_fd);

    // Close the socket
    close(connection_fd);

    return 0;
}

// Show the user how to run this program
void usage(char *program)
{
    printf("Usage:\n%s {server_address} {port_number}\n", program);
    exit(EXIT_FAILURE);
}

// Establish a connection with the server indicated by the parameters
int connectToServer(char *address, char *port)
{
    struct addrinfo hints;
    struct addrinfo *server_info;
    int connection_fd;

    // Prepare the information to determine the local address
    bzero(&hints, sizeof(hints)); // Clear all fields

    hints.ai_family = AF_INET; // Use internet sockets with IPv4

    hints.ai_socktype = SOCK_STREAM; // Use connected sockets

    hints.ai_flags = AI_PASSIVE; // Determine the ip of this machine automatically

    ///// GETADDRINFO
    // Get the actual address of the server
    if (getaddrinfo(address, port, &hints, &server_info) == -1)
    {
        perror("Error at getting the address info (client)");
        exit(1);
    }

    ///// SOCKET
    // Use the information obtained by getaddrinfo
    connection_fd = socket(server_info->ai_family, server_info->ai_socktype, server_info->ai_protocol);

    if (connection_fd == -1)
    {
        perror("Error in socket creation (client)");
        close(connection_fd);
        exit(1);
    }

    ///// CONNECT
    // Connect with the desired port
    if (connect(connection_fd, server_info->ai_addr, server_info->ai_addrlen) == -1)
    {
        perror("Binding error");
        close(connection_fd);
        exit(1);
    }
    // Release the memory of the list of addrinfo
    freeaddrinfo(server_info);

    // Release the memory of the list of addrinfo

    return connection_fd;
}

// Do the actual receiving and sending of data
void communicationLoop(int connection_fd)
{
    char playAgain = '1';

    while (playAgain == '1')
    {

        char buffer[BUFFER_SIZE];
        int chars_read;
        int card1, card2;
        int sum;
        int hitOrStand = 0;

        int dealerResult, clientMoney;
        int result;

        ///// RECV
        // Read the reply from the server
        bzero(buffer, sizeof buffer);
        receive(connection_fd, buffer);
        printf("%s \n", buffer); //Hello message
        fgets(buffer, BUFFER_SIZE, stdin);

        ///// SEND
        // Send a message to the server
        send(connection_fd, buffer, strlen(buffer) + 1, 0); //Send bet
        // Clear the buffer

        receive(connection_fd, buffer); //First two cards dealt
        sscanf(buffer, "%d %d", &card1, &card2);
        sum = card1 + card2;
        printf("The cards dealt to you are %d and %d. Your total is %d \n", card1, card2, sum);

        printf("Do you want to hit (0) or stand (1)? \n");
        hitOrStand = getchar();
        getchar();
        sprintf(buffer, "%c", hitOrStand);
        send(connection_fd, buffer, strlen(buffer) + 1, 0); //Send mandatory first hit or stand

        while (hitOrStand == '0')
        {
            receive(connection_fd, buffer);        //Receive third+ card from server
            sscanf(buffer, "%d %d", &card1, &sum); //get third+ card and total

            printf("You were dealt a %d. Your total is now %d \n", card1, sum);
            if (sum > 21)
            {
                printf("You have now GONE BUST. If you had an ace (11) it will now be worth 1 and you'll no longer be bust. Otherwise, you lose! \n");
                hitOrStand = '1';
            }
            else if (sum <= 21)
            {
                printf("Do you want to hit (0) or stand (1)? \n");
                hitOrStand = getchar();
                getchar();
            }

            sprintf(buffer, "%c", hitOrStand);
            send(connection_fd, buffer, strlen(buffer) + 1, 0); //Send hit or stand
        }
        receive(connection_fd, buffer);
        sscanf(buffer, "%d %d %d %d", &dealerResult, &clientMoney, &sum, &result);
        // printf("%s \n", buffer); //Uncomment for debug purposes
        switch (result)
        {
        case -1:
            printf("You lost! ");
            break;

        case 0:
            printf("You Tied. ");
            break;

        case 1:
            printf("You Won! Congrats! ");
            break;
        default:
            printf("How did you get here? GUARDS!");
            break;
        }
        printf("Your total was %d and the dealer's total was %d. Your balance is now %d. \nPlay again? (1) \n", sum, dealerResult, clientMoney);
        playAgain = getchar();
        getchar();
        if (clientMoney <= 0)
        {
            printf("Sorry, you have no more coins left. You have lost and must now leave the game. \n");
            playAgain = '0';
        }
        sprintf(buffer, "%c", playAgain);
        send(connection_fd, buffer, strlen(buffer) + 1, 0); //Send confirmation to play again.
    }
}

void receive(int connection_fd, char *buffer) //Because in this case sending of data is not template-able, only receive has its own dedicated function
{
    int chars_read;
    bzero(buffer, BUFFER_SIZE);
    chars_read = recv(connection_fd, buffer, BUFFER_SIZE, 0);

    if (chars_read == -1)
    {
        perror("reading error (client)");
        exit(1);
    }

    if (chars_read == 0)
    {
        perror("Server disconnected");
        exit(0);
    }
}
