#include <bits/stdc++.h>
#define V 5
using namespace std;

int minimo(int distancias[V], bool faltantes[V])
{
    int min_index = 0;
    int min_num = INT_MAX;

    for (int g = 0; g < V; g++)
    {
        if (faltantes[g] == true && distancias[g] < min_num)
        {
            min_num = distancias[g];
            min_index = g;
        }
        cout << min_index << endl;
    }
    return min_index;
}

void printMST(int parent[], int graph[V][V])
{
    cout << "Edge\n";
    for (int i = 1; i < V; i++)
        cout << parent[i] << endl;
}

void primMST(int graph[V][V], int inicio)
{
    int solucion[V];

    int distancias[V];

    bool faltantes[V];

    for (int i = 0; i < V; i++)
    {
        distancias[i] = INT_MAX;
        faltantes[i] = true;
    }

    distancias[inicio] = 0; //muestras que inicias en 0
    solucion[inicio] = -1;

    for (int c = 0; c < V - 1; c++)
    {
        int u = minimo(distancias, faltantes);

        faltantes[u] = false;

        for (int r = 0; r < V; r++)
        {
            if (graph[u][r] && faltantes[u] == true && graph[u][r] < distancias[r])
            {
                distancias[r] = graph[u][r];
                solucion[r] = u;
            }
        }
    }
    // printMST(solucion, graph);
}

int main(int argc, char const *argv[])
{

    /* int graph[V][V] = {{0, 2, 0, 6, 0},
                       {2, 0, 3, 8, 5},
                       {0, 3, 0, 0, 7},
                       {6, 8, 0, 0, 9},
                       {0, 5, 7, 9, 0}};
    primMST(graph, 0);

    */
    return 0;
}
