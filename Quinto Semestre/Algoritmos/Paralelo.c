#include <stdio.h>
#include <omp.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int n = 1000003;

    if (argc == 1)
    {
        printf("Use: %s <numero de elementos> \n", argv[0]);
    }
    else
        n = atoi(argv[1]);
    int suma = 0;
    int i;
    int suma_local = 0;
    double inicio;
    double final;
    int numeros[n];

    inicio = omp_get_wtime();
#pragma omp parallel for private(i) if (n > 100)
    for (i = 0; i < n; i++)
    {
        numeros[i] = 1;
    }

    final = omp_get_wtime();

    printf("Elapsed time (vector init): %.5f \n", (final - inicio));

    inicio = omp_get_wtime();
#pragma omp parallel private(i)
    {
        int numH = omp_get_num_threads();
        int tid = omp_get_thread_num();
        int num = n / numH;
        int inicio = tid * num;
        int fin = inicio + num;
        int suma_local = 0;

        if (tid == numH - 1)
        {
            fin = n;
        }
        for (i = inicio; i < fin; i++)
        {
            suma_local += numeros[i];
        }
        // printf("La suma parcial de %d es %d\n", tid + 1, suma_local);

#pragma omp critical
        {
            suma += suma_local;
        }
        //printf("Soy el hilo %d de %d\n", tid + 1, numH);
    }

    //printf("La suma es %d\n", suma);
    final = omp_get_wtime();

    printf("Elapsed time (calculations): %.5f \n", (final - inicio));
    return 0;
}
