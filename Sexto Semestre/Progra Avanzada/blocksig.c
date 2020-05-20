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
#include <signal.h>

#define LIFETIME 20

// Function declarations
sigset_t setupMask();
void unsetMask(sigset_t old_set);
void detectBlocked(int signal);
void waitLoop();

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

    // Change the signal masks
    old_set = setupMask();

    // Wait a few seconds before quiting on its own
    waitLoop(seconds);

    // Check if any signals are blocked
    detectBlocked(SIGINT);
    // Remove the masks
    unsetMask(old_set);

    // Wait a few seconds before quiting on its own
    waitLoop(seconds);

    return 0;
}

// Function definitions

// Modify the signal mask
sigset_t setupMask()
{
    sigset_t new_set;
    sigset_t old_set;

    if (sigemptyset(&new_set) == -1)
    {
        perror("Error in empty set declaration");
        exit(1);
    }

    if (sigaddset(&new_set, SIGINT) == -1)
    {
        perror("Error in adding SIGINT");
        exit(1);
    }

    if (sigprocmask(SIG_BLOCK, &new_set, &old_set) == -1)
    {
        perror("Error in sigprocmask");
        exit(1);
    }
    return old_set;
}

// Reset the blocking mask to the previous one
void unsetMask(sigset_t old_set)
{

    if (sigprocmask(SIG_SETMASK, &old_set, NULL) == -1)
    {
        perror("Error in sigprocmask");
        exit(1);
    }
}

void detectBlocked(int signal)
{
    sigset_t pending;
    if (sigpending(&pending) == -1)
    {
        perror("Error: pending");
    }

    if (sigismember(&pending, signal))
    {
        printf("Received signal %d. Program will now terminate \n", signal);
    }
    else
    {
        printf("Keep going \n");
    }
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