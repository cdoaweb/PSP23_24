#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Uso: %s <comando> [argumentos...]\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    // Crear un proceso hijo
    pid_t pid = fork();

    if (pid == -1) {
        // Error al crear el proceso hijo
        perror("fork");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Estamos en el proceso hijo
        // Ejecutar el comando con sus argumentos en el proceso hijo
        if (execvp(argv[1], &argv[1]) == -1) {
            perror("execvp");
            exit(EXIT_FAILURE);
        }
    } else {
        // Estamos en el proceso padre
        // Esperar a que el proceso hijo termine
        int status;
        if (wait(&status) == -1) {
            perror("wait");
            exit(EXIT_FAILURE);
        }

        if (WIFEXITED(status)) {
            printf("El proceso hijo terminó con estado %d\n", WEXITSTATUS(status));
        } else {
            printf("El proceso hijo terminó de forma anormal\n");
        }
    }

    return 0;
}