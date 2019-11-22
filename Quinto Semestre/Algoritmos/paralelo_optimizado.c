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
#pragma omp parallel for private(i) reduction(+ \
                                              : suma_local)
    for (i = 0; i < n; i++)
    {
        suma_local += numeros[i];
        int id = omp_get_thread_num();
        printf("Hilo %d = [%d]\n", id, i);
    }

    printf("La suma es %d\n", suma_local);
    final = omp_get_wtime();

    printf("Elapsed time (calculations): %.5f \n", (final - inicio));
    return 0;
}
