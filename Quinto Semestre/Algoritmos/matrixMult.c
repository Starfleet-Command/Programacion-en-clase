/*
<Juan Francisco Gortarez Ricardez>:<A01021926>
*/
#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#define M 3
#define K 2
#define N 3

int A[M][K] = {{1,2},{3,4},{5,6}};
int B[K][N] = {{7,8,9},{10,11,12}};
int C[M][N];

struct p
{
  int i;
  int j;
};

void *suma(void *arg)
{
struct p *param=(struct p *)arg;
int fila=param->i;
int columna= param->j;

C[fila][columna]= A[fila][columna]+ B[fila][columna];
}

void *multiplica(void *arg)
{
  struct p *param=(struct p *)arg;


  for(int k=0;k<M;k++)
  {

    for(int r=0;r<N;r++)
    {
      C[k][r]=0;
      for(int s=0;s<K;s++)
      {
      C[k][r]+=A[k][s]*B[s][r];
      }
    }
  }
}

void printMatrix()
{
for(int filas=0;filas<M;filas++)
{
  for(int cols=0;cols<N;cols++)
  {
    printf("%d ",C[filas][cols]);
  }
  printf("\n");
}
}

int main()
{
  pthread_t workers[M][N];
  for(int filas=0;filas<M;filas++)
  {
    for(int cols=0;cols<N;cols++)
    {
      struct p *temp= malloc(sizeof(struct p));
      temp->i=filas;
      temp->j=cols;
      pthread_create(&workers[filas][cols],NULL,multiplica,(void *) temp);

    }
  }

  for(int filas=0;filas<M;filas++)
  {
    for(int cols=0;cols<N;cols++)
    {
      pthread_join(workers[filas][cols],NULL);
    }
  }


  printMatrix();
  return 0;
}
