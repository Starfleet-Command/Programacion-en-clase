#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int b = 0;

pthread_mutex_t lockVariable;
void *crit_section(void *m)
{
    pthread_t *id = (pthread_t *)m;
    printf("Thread %ld entering critical section \n", *id);
    pthread_mutex_lock(&lockVariable);
    printf("In critical section \n");

    b++;
    printf("variable = %d \n", b);

    sleep(2);
    printf("Thread %ld out of critical section \n", *id);
    pthread_mutex_unlock(&lockVariable);
}
int main(int argc, char const *argv[])
{
    pthread_t tId;
    pthread_t tId2;
    void *point1;
    void *point2;

    pthread_create(&tId, NULL, crit_section, (void *)point1);
    pthread_create(&tId2, NULL, crit_section, (void *)point2);
    pthread_join(tId, NULL);
    pthread_join(tId2, NULL);
    return 0;
}
