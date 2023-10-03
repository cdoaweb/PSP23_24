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
/*Este programa crea un proceso hijo utilizando fork(), y ambos el proceso padre y el proceso hijo operan en su propia copia de la variable X. Por lo tanto, el proceso hijo incrementa x a 2 y el proceso padre lo decrementa a 0, y estos valores se muestran en la consola como "Child has x = 2" y "Parent has x = 0", respectivamente. Esto demuestra cómo las variables tienen su propio espacio de memoria en procesos separados y cómo los cambios en una variable en un proceso no afectan a la variable en el otro proceso.*/