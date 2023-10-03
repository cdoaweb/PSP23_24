#include <stdio.h>
#include </usr/include/linux/types.h>
#include <unistd.h>
int main()
{
    fork();
    fork();
    fork();
    printf("hello\n");
    return 0;
}

/*Este bucle fork() crea una estructura de árbol de procesos donde cada proceso padre se divide en dos procesos hijos en cada iteración. Luego, estos procesos hijos también se dividen en dos procesos hijos en la siguiente iteración, y así sucesivamente. Cada proceso imprimirá "hello" en la consola.*/