#include <stdio.h>
#include <omp.h>
#include <stdlib.h>
#include <time.h>
#include <vector>
#include <iostream>
#include <unistd.h>
#include <algorithm>
#include <chrono>

using namespace std;

bool comparison(const pair<int, chrono::microseconds> &a, const pair<int, chrono::microseconds> &b)
{
    return a.second < b.second;
}

int hasAccident()
{
    int random = rand() % 11;
    if (random == 5)
    {
        return 1;
    }
    else
        return 0;
}

void printStandings(vector<int> stands, vector<chrono::microseconds> times)
{
    vector<int> stripped;
    vector<pair<int, chrono::microseconds>> joined;

    for (int s = 0; s < stands.size(); s++)
    {

        if (!count(stripped.begin(), stripped.end(), stands.at(s)))
        {
            pair<int, chrono::microseconds> temp;
            temp.first = stands.at(s);
            temp.second = times.at(s);
            joined.push_back(temp);
            stripped.push_back(stands.at(s));
        }
    }
    sort(joined.begin(), joined.end(), comparison);
    for (int c = 0; c < joined.size(); c++)
    {
        cout << "Competidor " << joined.at(c).first << " Con: " << joined.at(c).second.count() << " microsegundos " << endl;
    }
}

int main(int argc, char const *argv[])
{
    if (argc < 3)
    {
        printf("Uso: ./Proyecto_Final <numero de etapas> <numero de competidores>");
    }
    srand(time(NULL));
    int num_competidores, etapas;
    int r;
    int q;
    int progreso = 0;
    etapas = atoi(argv[1]);
    num_competidores = atoi(argv[2]);
    omp_set_num_threads(num_competidores);
    vector<int> standings;
    vector<chrono::microseconds> tiempos;

    for (q = 0; q < etapas + 1; q++)
    {
        printf("Etapa %d \n", q);
        printStandings(standings, tiempos);
        standings.clear();
        auto start = chrono::high_resolution_clock::now();
#pragma omp parallel for private(r)
        for (r = 0; r < 100; r++)
        {
            int flag = hasAccident();
            if (flag == 1)
            {
                //printf("Accidente de %d \n", omp_get_thread_num() + 1);
                sleep(0.002);
            }
            progreso += 1;
            int id = omp_get_thread_num() + 1;
            auto stop = chrono::high_resolution_clock::now();

            auto duration = chrono::duration_cast<chrono::microseconds>(stop - start);
#pragma omp critical
            {
                standings.push_back(id);
                tiempos.push_back(duration);
            }
        }
    }

    return 0;

    //TODO: Implementar accidentes,medir progreso, checar orden en vector,
}
