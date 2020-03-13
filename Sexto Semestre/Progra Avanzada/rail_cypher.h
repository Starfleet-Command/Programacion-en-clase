/*
    Header file for the Rail-Cypher HW
    Juan Francisco Gortarez Ricardez 
    09/03/2020
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <getopt.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdbool.h>

#define maxRow 100
#define maxCol 100

char *encode(int rails, char *message);

char *decode(int rails, char *encodedMessage);

char *readFile(char *filename);

char *writeFile(char *filename, int willDecode, int willEncode, char *message);
