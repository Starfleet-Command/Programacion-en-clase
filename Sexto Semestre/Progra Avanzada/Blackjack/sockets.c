/*
    Server program for playing Blackjack with multiple concurrent clients
    Juan Francisco Gortarez A01021926
    15/04/2020
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <time.h>
// Include libraries for sockets
#include <netdb.h>
#include <arpa/inet.h>

#define MAX_QUEUE 5
#define BUFFER_SIZE 1024

void usage(char *program);
int startServer(char *port);
void waitForConnections(int server_fd);
char *sendReceive(int connection_fd, char *dataToSend);
void blackjack(int connection_fd);
int cardGenerator(int *numAces);

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
            blackjack(connection_fd);
            exit(0);
        }

        else
        {
            close(connection_fd);
        }
    }
}

int cardGenerator(int *numAces) //Generates a card with 52-card deck odds
{
    int card;

    //Allot time for the seed to change so you don't get identical results
    card = (rand() % 53 + 1) % 14 + 1; //A card must be generated out of a pool of 52, and there are 13 possible values for the card to take (cannot be 0)
    if (card >= 11)                    //There are 13 distinct cards but cards 11 12 and 13 (J Q K) are all worth 10
    {
        card = 10;
    }
    if (card == 1) //If the card is an ace, we set it's value to 11.
    {
        (*numAces)++;
        card = 11;
    }

    return card;
}

void blackjack(int connection_fd)
{
    srand(time(0));
    int playAgain = 1;
    int clientMoney = 2000; //Starting amount. Updated after every round
    while (playAgain)
    {

        char buffer[BUFFER_SIZE];
        int hitOrStand; //if 0, hit. If 1, stand.
        int bet, currentCard, dealerCurrentCard;
        int sum = 0;
        int dealerSum = 0;
        int hasLost = 0; //Check for busts.
        int dealerHasLost = 0;
        int isAce = 0;
        int cardsHit = 0;
        int dealerCardsHit = 0; //Check for blackjack. If > 0, blackjack is not possible
        int result;

        sprintf(buffer, "Welcome to Blackjack! You have %d coins. To play, type your bet and press enter! ", clientMoney);
        strcpy(buffer, sendReceive(connection_fd, buffer));
        sscanf(buffer, "%d", &bet);
        if (bet > clientMoney) //Stop users from betting more than they have.
        {
            bet = clientMoney;
        }

        currentCard = cardGenerator(&isAce); //Serve up the first two cards.

        sum += currentCard;

        currentCard = cardGenerator(&isAce);

        sum += currentCard;

        sprintf(buffer, "%d %d", sum - currentCard, currentCard);
        strcpy(buffer, sendReceive(connection_fd, buffer)); //Send the cards to the client
        sscanf(buffer, "%d", &hitOrStand);

        while (hitOrStand == 0) //While the client doesn't stand, keep giving them more cards
        {
            currentCard = cardGenerator(&isAce);
            cardsHit++;
            sum += currentCard;

            sprintf(buffer, "%d %d", currentCard, sum);
            strcpy(buffer, sendReceive(connection_fd, buffer));
            sscanf(buffer, "%d", &hitOrStand);
        }

        while (sum > 21 && isAce) //Reduce values of aces from 11 to 1 if needed.
        {
            sum = sum - 10;
            isAce--;
        }

        if (sum > 21) //If after everything the sum is still > 21, the client is bust
        {
            hasLost = 1;
        }

        isAce = 0;

        dealerCurrentCard = cardGenerator(&isAce); //Card dealing procedure, as with client
        printf("%d \n", dealerCurrentCard);

        dealerSum += dealerCurrentCard;
        printf("Total: %d \n", dealerSum);

        dealerCurrentCard = cardGenerator(&isAce);
        printf("%d \n", dealerCurrentCard);
        fflush(stdout);
        dealerSum += dealerCurrentCard;
        printf("Total: %d \n", dealerSum);

        while (dealerSum < 17) //House rules state the dealer must hit until they reach either 16/17
        {
            dealerCurrentCard = cardGenerator(&isAce);
            dealerSum += dealerCurrentCard;
            //printf("%d \n", dealerCurrentCard);
            // printf("Total: %d \n", dealerSum);
            dealerCardsHit++;
        }
        printf("Total: %d \n", dealerSum);

        while (dealerSum > 21 && isAce) //Same as with client
        {

            dealerSum = dealerSum - 10;
            isAce--;
        }

        if (dealerSum > 21)
        {
            dealerHasLost = 1;
        }
        printf("Total after adjustments: %d \n", dealerSum);

        if (hasLost || ((dealerSum > sum) && !dealerHasLost) || (dealerSum = 21 && !dealerCardsHit && !(sum == 21 && !cardsHit))) //Player loses IF: Bust, dealer cards are higher, or Dealer blackjacks and player does not
        {
            clientMoney -= bet;
            result = -1;
            printf("Total in slot 1: %d \n", dealerSum);
        }
        else if ((dealerHasLost && !hasLost) || ((sum > dealerSum) && !hasLost) || ((sum == 21 && !cardsHit) && !(dealerSum = 21 && !dealerCardsHit))) //Player wins IF: Dealer bust and player not bust, player cards are higher or Player blackjacks and dealer does not
        {
            clientMoney += bet;
            result = 1;
            //printf("Total in slot 2: %d \n", dealerSum);
        }

        else if (((sum == dealerSum) && !hasLost && !dealerHasLost) || ((dealerSum = 21 && !dealerCardsHit) && (sum == 21 && !cardsHit))) //Player and dealer tie IF: Both hands have same value, or both blackjack.
        {
            result = 0;
            // printf("Total in slot 3: %d \n", dealerSum);
        }
        printf("%d \n", dealerSum); // I DO NOT UNDERSTAND how it gives 0. In all the prints the value is the correct one and in this one it alternates seemingly at random. I tested multiple scenarios and there was no way of replicating the bug. If you find how lmk
        sprintf(buffer, "%d %d %d %d", dealerSum, clientMoney, sum, result);

        strcpy(buffer, sendReceive(connection_fd, buffer)); //Send the final result to client
        sscanf(buffer, "%d", &playAgain);
    }
}

// Do the actual receiving and sending of data
char *sendReceive(int connection_fd, char *dataToSend)
{
    int chars_read;

    ///// SEND
    // Send a reply to the client
    send(connection_fd, dataToSend, strlen(dataToSend) + 1, 0);

    // Clear the buffer
    bzero(dataToSend, BUFFER_SIZE);

    ///// RECV
    // Read the request from the client
    chars_read = recv(connection_fd, dataToSend, BUFFER_SIZE, 0);
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
        exit(0);
    }
    return dataToSend;
}