#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
void* printMessage(void *m)
{
  char *message= (char *)m;
  sleep(5);
  printf("%s\n",message);
}

int main()
{
  pthread_t tId;
  char *m = "Hello World";
  pthread_create(&tId,NULL,printMessage, (void * )m);
  printf("Created thread: %ld\n",tId);
  pthread_join(tId, NULL);
}
