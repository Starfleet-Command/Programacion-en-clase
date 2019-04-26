#include <stdio.h>

int main()
{
  int a=10;
  double b=20;
  char c='A';
  //*a
  //Muestra la ubicacion de memoria del valor de la variable, en este caso 10.
  int *pa=&a;
  //&a
  //Muestra la ubicacion de memoria de la variable, en este caso a.

  int d[5] = {1,2,3,4,5};
  int i;
  for(i=0;i<10;i++)
  {
    printf("%d\n",i);
  }
  return 0;

}
