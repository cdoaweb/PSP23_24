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

/*
La función fork() para crear un proceso hijo y luego solicita al usuario que ingrese un número hasta que ingresen 0 para salir del bucle.
1.
La función main():
Declara una variable pid_t llamada pid que se utilizará para almacenar el valor de retorno de fork(). pid_t es un tipo de datos específico de UNIX/Linux utilizado para representar identificadores de proceso (PIDs).
Llama a fork() para crear un nuevo proceso. Después de la bifurcación, el valor de `pid` será 0 en el proceso hijo y será el PID del proceso hijo en el proceso padre.
Declara una variable op inicializada en 1, que se usará para solicitar al usuario que ingrese un número en un bucle.
Entra en un bucle while que se ejecutará hasta que el usuario ingrese el número 0 (op sea igual a 0).
Dentro del bucle, se utiliza una instrucción switch para determinar qué imprimir en función del valor de pid.
Si pid es -1, indica un error y muestra "Error".
Si pid es 0, significa que estamos en el proceso hijo y muestra "Proceso hijo".
Si pid es diferente de 0, significa que estamos en el proceso padre y muestra "Proceso padre".
Luego, se solicita al usuario que ingrese un número con scanf() y se almacena en op. El bucle continuará hasta que op sea igual a 0.
2.
Al final, el programa termina y devuelve 0.
*/