#include <stdio.h>
#include </usr/include/linux/types.h>
#include <unistd.h>

int main()
{
    int pid;

    // make two process which run same
    // program after this instruction
    pid =fork();
    if(pid !=0)
        printf("Soy el proceso padre\n")
    else
        printf("Soy el proceso hijo\n")
  
    printf("Finalizamos\n");
    return 0;
}
/*
el fork crea un proceso hijo que es clon del proceso padre
ambos procesos, tienen el mismo código y las mismas variables
Cuando ejecuta el fork, al proceso padre le devuelve el pid del hijo
que será distinto de cero. Al proceso hijo, le devuelve el valor 0.
Ambos procesos, deberán ejecutar la instrucción siguiente al fork.
Cuando le toque al padre, comprueba que su pid es distinto de cero, por tanto
ejecuta soy el proceso padre y se salta el else. Acabará ejecutando el -ultimo print
Cuando le toque al hijo, como su pid es cero, saltará al else e imprimira
Soy el proceso hijo y después imprime finalizamos.
¿Puedo asegurar el orden de ejecución del padre o el hijo? No, es el S.O. el que
decide quien se ejecuta primiero.
*/
/* La función fork() crea un nuevo proceso hijo que es una copia exacta del proceso padre. Y la llamada a fork(). Ambos imprimirán "Hello world!\n" en la consola.*/