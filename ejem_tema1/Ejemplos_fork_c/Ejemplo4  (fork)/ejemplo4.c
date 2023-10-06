#include <stdio.h>
#include </usr/include/linux/types.h>
#include <unistd.h>

void forkexample()
{
    int x = 1;
  
    if (fork() == 0)
        printf("Child has x = %d\n", ++x);
    else
        printf("Parent has x = %d\n", --x);
}
int main()
{
    forkexample();
    return 0;
}

/*
Fork() crea un proceso hijo que es una copia exacta del proceso padre, incluyendo las variables. Sin embargo, los procesos hijo y padre tienen sus espacios de memoria separados, por lo que las modificaciones de variables en uno de los procesos no afectan a la otra.
1.
Se define la función forkexample():
Se declara una variable x con el valor inicial 1.
Luego, se llama a fork() para crear un nuevo proceso. Tanto el proceso hijo como el proceso padre tienen su propia copia de x.
Si el valor de retorno de fork() es 0, significa que estamos en el proceso hijo. En este caso, incrementamos x en 1 y luego imprimimos el valor actualizado de x en el proceso hijo.
Si el valor de retorno de fork() es diferente de 0, significa que estamos en el proceso padre. En este caso, decrementamos x en 1 y luego imprimimos el valor actualizado de x en el proceso padre.
2.
En la función main():
Se llama a forkexample(), que es donde ocurre la bifurcación del proceso.
La salida del programa dependerá del orden en que se ejecuten los procesos, pero debido a que x es independiente en cada proceso, el resultado será:
En el proceso hijo, x se incrementa a 2 y se imprime como "Child has x = 2".
En el proceso padre, x se decrementa a 0 y se imprime como "Parent has x = 0".
*/