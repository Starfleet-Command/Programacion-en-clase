#include<stdio.h>
#include <chrono>
#include <iostream>

using namespace std;
using namespace std::chrono;

int fibo(int n)
{
  int x,y,suma;

  if(n<=1)
  {
    return 1;
  }
  else
  {
    x=1;
    y=1;
    for(int i=2; i<n;++i)
    {
      suma=x+y;
      y=x;
      x=suma;
    }
  }
  return suma;
}

int main()
{
  int n = 100000;
  auto start = high_resolution_clock::now();
  printf("%d", fibo(n));
  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);
  cout << "La duracion es: "<< duration.count() << endl;
  getchar();
  return 0;

}
