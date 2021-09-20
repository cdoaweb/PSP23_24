#include <stdio.h>
#include </usr/include/linux/types.h>
#include <unistd.h>
#include <stdlib.h>
#include </usr/include/linux/wait.h>

int main(){
	int pid;
	int status;
	char *argumentos[3] = {"ls","-l", NULL};

	pid = fork();
	printf("El valor del pid del hijo es: %d ", pid);
	printf("El valor del pid del padre es: %d ", getpid());

	switch (pid){
		case -1:
			perror("Error de fork\n");
			exit(-1);
		case 0:
			execvp(argumentos[0],argumentos);
			perror("Error de exec. Si todo ha ido bien esto no se ejecuta");
			exit(-1);
			break;
		default:
			while(wait(&status) != pid);
			if  (status == 0)
				printf("Ejecución normal proceso hijo\n");
			else
				printf("Error del hijo\n");
	}
	exit(0);



}

