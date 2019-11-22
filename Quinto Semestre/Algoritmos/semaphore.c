#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>
int b = 0;

sem_t sem;
void *crit_section(void *m)
{
    pthread_t *id = (pthread_t *)m;
    printf("Thread %ld entering critical section \n", *id);
    sem_wait(&sem);
    printf("In critical section \n");

    b++;
    printf("variable = %d \n", b);

    sleep(2);
    printf("Thread %ld out of critical section \n", *id);
    sem_post(&sem);
}
int main(int argc, char const *argv[])
{
    sem_init(&sem, 0, 1);
    pthread_t tId;
    pthread_t tId2;
    void *point1;
    void *point2;

    pthread_create(&tId, NULL, crit_section, (void *)point1);
    pthread_create(&tId2, NULL, crit_section, (void *)point2);
    pthread_join(tId, NULL);
    pthread_join(tId2, NULL);
    sem_destroy(&sem);
    return 0;
}
