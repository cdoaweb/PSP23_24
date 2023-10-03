import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el número de objetos Alumno a crear
        System.out.print("Ingrese el número de alumnos: ");
        int numAlumnos = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Crear una lista dinámica para almacenar los objetos Alumno
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        // Pedir los detalles de cada alumno y agregarlos a la lista
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("\nIngrese los detalles del alumno " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            Alumno alumno = new Alumno(nombre, apellidos, edad, curso);
            listaAlumnos.add(alumno);
        }

        // Mostrar la lista de alumnos
        System.out.println("\nLista de Alumnos:");
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno.toString());
        }

        // Cerrar el escáner
        scanner.close();
    }
}