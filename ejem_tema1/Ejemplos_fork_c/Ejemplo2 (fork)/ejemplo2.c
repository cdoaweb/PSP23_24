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

/*
Se utiliza la función fork() para crear procesos hijo en serie. Cada vez que se llama a fork(), el proceso actual se divide en dos, creando un nuevo proceso hijo que es una copia exacta del proceso padre, incluido el código y los datos.
1.
En el proceso original (proceso padre), se llama a fork() por primera vez. Esto crea un nuevo proceso hijo que es una copia del proceso padre. Ahora hay dos procesos: el proceso padre y el proceso hijo 1.
2.
En ambos procesos (padre e hijo 1), se llama a fork() por segunda vez. Esto crea un nuevo proceso hijo en cada uno de ellos. Entonces, ahora ay cuatro procesos: proceso padre, hijo 1, hijo 1 del hijo 1 (nieto 1) y hijo 2 del proceso padre.
3.
En cada uno de los cuatro procesos, se llama a fork() por tercera vez. Esto crea un nuevo proceso hijo en cada uno de ellos. Ahora se tiene un total de ocho procesos: proceso padre, hijo 1, nieto 1, bisnieto 1, hijo 2, nieto 2, bisnieto 2, y nieto 1 del hijo 1 (tataranieto 1).
4.
Cada uno de los ocho procesos imprime "hello\n" en la pantalla.
Como resultado, se verá la cadena "hello" impresa en la pantalla ocho veces, una vez por cada uno de los ocho procesos creados.
La llamada a fork() crea un árbol de procesos en el que cada proceso padre crea uno o más procesos hijos, y este proceso se repite en cascada. Por eso, se imprime "hello" ocho veces, ya que hay ocho procesos en total.
*/