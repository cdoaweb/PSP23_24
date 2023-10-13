#include <stdio.h>
#include </usr/include/linux/types.h>
#include <unistd.h>

void forkexample()
{
    // child process because return value zero
    if (fork() == 0)
        printf("Hello from Child!\n");
  
    // parent process because return value non-zero.
    else
        printf("Hello from Parent!\n");
}
int main()
{
    forkexample();
    return 0;
}

/*
La función fork() crea una copia exacta del proceso que la llama, lo que resulta en dos procesos distintos: uno es el proceso padre y el otro es el proceso hijo.
1.
Se define la función forkexample():
Dentro de forkexample(), se llama a `fork()` y se verifica su valor de retorno.
Si el valor de retorno es 0, significa que estamos en el proceso hijo. Por lo tanto, se imprime "Hello from Child!".
Si el valor de retorno es diferente de 0, significa que estamos en el proceso padre. Por lo tanto, se imprime "Hello from Parent!".
2.
En la función main():
Se llama a forkexample(), que es donde ocurre la bifurcación del proceso.
A la hora de la salida no sabemos cual se ejecutará primero, eso ya será a elección del sistema.
*/