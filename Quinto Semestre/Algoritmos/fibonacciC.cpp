#include<stdio.h>
#include <chrono>
#include <iostream>

using namespace std;
using namespace std::chrono;
int fib(int n)
{
   if (n <= 1)
      return n;
   return fib(n-1) + fib(n-2);
}

int main ()
{
  int n = 1000;
  auto start = high_resolution_clock::now();
  printf("%d", fib(n));
  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<milliseconds>(stop - start);
  cout << "La duracion es: "<< duration.count() << endl;
  getchar();
  return 0;
}
