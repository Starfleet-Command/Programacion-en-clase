/*
 * OS_Forks.cpp
 *
 *  Created on: 6 sep. 2019
 *      Author: Juan Fco
 */

#include <sys/wait.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(){
	pid_t parentPid = getpid();
	pid_t newPid = fork();
	int a =0;
	//pid_t newPID = fork();
	//pid_t pid = getpid();
	//char s[5] = "dogs!";
	//printf("My process id is : %d\n", pid);
	if(newPid > 0){
		wait(NULL);
	printf("I am the process %d and my child is %d \n", parentPid, newPid);
	printf("Value of variable a in parent is %d \n", a);
	}else{
		a=1;
	pid_t myPid=getpid();
	printf("I am process %d and my child is %d \n", myPid, newPid);
	printf("Value of variable a in parent is %d \n", a);
	execl("/mnt/c/Users/Juan \Fco/Desktop/Programacion/Quinto \Semestre/Algoritmos/OS/OS_Fork","OS_Fork");
	}
	return 0;
}
