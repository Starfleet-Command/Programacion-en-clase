/*
Juan Francisco Gortarez Ricardez A01021926
*/

#include <sys/wait.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int zombie()
{
        pid_t parentPid = getpid();
        pid_t child = fork();

        if(child > 0) {
                printf("Parent is going to sleep \n");
                sleep(30);
                printf("Parent has woken up \n");
        }else{
                printf("Parent is asleep, now the child can PARTY and run away\n");
                exit(0);
        }
        return 0;
}

int orphan()
{
        int child_pid = fork();

        if(child_pid >0)
        {
                printf("Parent is being responsible. Hasnt abandoned their child yet \n");
        }

        else if(child_pid==0)
        {
                printf("Now the child is going to wait at the mall. \n");
                sleep(30);
                printf("Child cant find mom and dad. Child is now an orphan\n ");

        }
        return 0;
}

int terminated()
{
        pid_t child_pid = fork();

        if(child_pid >0)
        {
                printf("Child is in the park, parent waiting \n");
                waitpid(-1,&child_pid,0);
                printf("Child is finished, lets wrap this up. \n");

        }

        else if(child_pid==0)
        {
                printf("Child is playing in the park! \n");
                sleep(5);
                printf("Child has finished playing. Exiting park.");

        }
        return 0;
}

int suspend()
{
  char r;
  printf("Enter one character (This process is now in suspension) \n");
  scanf("%c",&r);
  printf("Exited suspension. Terminating");
  return 0;
}


int main(){
        int c;

        printf("Choose the process to test: \n 1. Termination  2. Zombies  3. Orphans 4. Suspension \n");
        scanf("%d",&c);
        getchar();
        switch(c)
        {
        case 1:
                terminated();
                break;

        case 2:
                zombie();
                break;

        case 3:
                orphan();
                break;

        case 4:
        suspend();
                break;

        default:
                printf("Wrong input. please choose one of the four numbers");
                exit(0);
        }

        /* execl("/mnt/c/Users/Juan \Fco/Desktop/Programacion/Quinto \Semestre/Algoritmos/OS/OS_Fork","OS_Fork");
         */

        return 0;
}
