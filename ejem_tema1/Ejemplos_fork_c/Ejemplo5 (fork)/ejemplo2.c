/*#include <sys/types.h>*/
#include </usr/include/linux/types.h>
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char** argv) {
	pid_t pid;
	pid = fork();
	int op=1;


	while (op!=0){
		switch (pid) {
			case -1: /* error */
				printf("Error");
				exit(-1);
			case 0: /* proceso hijo */
				printf("Proceso hijo\n");
				break;
			default:
				printf("Proceso padre\n");
		}
		printf("Escribe un numero");
		scanf("%i", &op);
	}
	return 0;
}
