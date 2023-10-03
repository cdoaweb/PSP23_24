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

/*Este programa crea un proceso hijo utilizando fork(), y ambos el proceso padre y el proceso hijo imprimen mensajes diferentes en la consola para indicar si son el proceso padre o el proceso hijo. Como resultado, habrá dos líneas de salida en la consola: "Hello from Parent!" y "Hello from Child!".*/