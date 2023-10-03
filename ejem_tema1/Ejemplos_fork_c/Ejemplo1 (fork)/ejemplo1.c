#include <stdio.h>
#include </usr/include/linux/types.h>
#include <unistd.h>

int main()
{
  
    // make two process which run same
    // program after this instruction
    fork();
  
    printf("Hello world!\n");
    return 0;
}
/* La función fork() crea un nuevo proceso hijo que es una copia exacta del proceso padre. Y la llamada a fork(). Ambos imprimirán "Hello world!\n" en la consola.*/