/*
    Program to test the blocking of signals
    It can take a number of seconds to live as an argument
    Gilberto Echeverria
    gilecheverria@yahoo.com
    28/02/2017
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <signal.h>

#define LIFETIME 20

// Function declarations
void setupHandler();
void unsetMask(sigset_t old_set);
void detectBlocked(int signal);
void waitLoop();
void onInterrupt(int signal);

int main(int argc, char *argv[])
{
    int seconds;
    sigset_t old_set;

    // Use a timeout obtained as an argument
    if (argc >= 2)
        seconds = atoi(argv[1]);
    // Otherwise use a default time
    else
        seconds = LIFETIME;

    // Change the signal handlers
    setupHandler();

    // Wait a few seconds before quiting on its own
    waitLoop(seconds);

    // Check if any signals are blocked

    // Remove the masks

    // Wait a few seconds before quiting on its own
    waitLoop(seconds);

    return 0;
}

void onInterrupt(int signal)
{
    printf("Ha! Got IM");
    //IF you want to use program data or communicate sth you need to use global variables.
}

// Function definitions

// Modify the signal mask
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

// Reset the blocking mask to the previous one
void unsetMask(sigset_t old_set)
{
}

void detectBlocked(int signal)
{
}

// Wait a few seconds until the program ends
void waitLoop(int seconds)
{
    int i;

    // Show the PID so that it can be sent signals form the terminal
    //  or other process
    printf("My PID is: %d\n", getpid());

    printf("Will finish on my own in %3d s", seconds);
    fflush(stdout);
    // Loop to wait for something to happen
    for (i = seconds - 1; i >= 0; i--)
    {
        sleep(1);
        printf("\b\b\b\b\b%3d s", i);
        fflush(stdout);
    }
    printf("\nTime out. Good bye\n");
}