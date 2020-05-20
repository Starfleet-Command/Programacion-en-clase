#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void *threadFunction(void *data);
long number;

int main(int argc, char *argv[])
{

    int numthreads = 2;
    if (argc == 2)
    {
        numthreads = atoi(argv[1]);
    }
    pthread_t tid[numthreads];

    printf("Launching threads\n");

    for (size_t i = 0; i < numthreads; i++)
    {
        pthread_create(&tid[i], NULL, threadFunction, NULL);
    }

    for (size_t r = 0; r < numthreads; r++)
    {
        pthread_join(tid[r], NULL);
    }

    printf("Main Thread finished \n");
    printf("The number ends at: %ld in THE MAIN THREAD \n", number);
    pthread_exit(NULL);

    return 0;
}

void *threadFunction(void *data)
{
    printf("Running thread with id: %lu \n", pthread_self());
    for (long a = 0; a < 10000000; a++)
    {

        number = number + 1;
    }

    printf("The number ends at: %ld \n", number);
    printf("Thread %lu finishing \n", pthread_self());
    return NULL;
}