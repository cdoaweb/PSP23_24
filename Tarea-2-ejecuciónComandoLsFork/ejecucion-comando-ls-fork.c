#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    // Crear un array de argumentos para el comando ls -l
    char *argumentos[] = {"ls", "-l", NULL};

    // Crear un proceso hijo
    pid_t pid = fork();

    if (pid == -1) {
        // Error al crear el proceso hijo
        perror("fork");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Estamos en el proceso hijo
        // Ejecutar el comando ls -l en el proceso hijo
        execvp(argumentos[0], argumentos);
        
        // Si llegamos a esta línea, ha habido un error en execvp
        perror("execvp");
        exit(EXIT_FAILURE);
    } else {
        // Estamos en el proceso padre
        // Esperar a que el proceso hijo termine
        int status;
        wait(&status);

        if (WIFEXITED(status)) {
            printf("El proceso hijo terminó con estado %d\n", WEXITSTATUS(status));
        } else {
            printf("El proceso hijo terminó de forma anormal\n");
        }
    }

    return 0;
}