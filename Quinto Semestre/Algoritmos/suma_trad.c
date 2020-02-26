#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#define N 10

int main(int argc, char const *argv[])
{
    srand(time(NULL));
    int i, s;
    int A[N][N], B[N][N], S[N][N];

#pragma omp parallel for private(i) shared(A, B, S) collapse(2)
    for (i = 0; i < N; i++)
    {
        for (s = 0; s < N; s++)
        {
            A[i][s] = rand() % 100;
            B[i][s] = rand() % 100;
        }
    }
#pragma omp parallel for private(i) shared(A, B, S) collapse(2)
    for (i = 0; i < N; i++)
    {
        for (s = 0; s < N; s++)
        {
            S[i][s] = A[i][s] + B[i][s];
        }
    }

    for (i = 0; i < N; i++)
    {
        for (s = 0; s < N; s++)
        {
            printf("%d ", S[i][s]);
        }
        printf("\n");
    }

    return 0;
}
