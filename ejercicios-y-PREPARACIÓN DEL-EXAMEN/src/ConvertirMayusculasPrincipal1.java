import java.io.*;
import java.util.Scanner;

public class ConvertirMayusculasPrincipal1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una línea:");

        String linea = scanner.nextLine();

        ProcessBuilder procesoBuilder = new ProcessBuilder("java", "-cp", "convertir.jar", "ConvertirMayusculas");
        try {
            Process proceso = procesoBuilder.start();

            OutputStream flujoSalidaPadre = proceso.getOutputStream();
            PrintWriter escritor = new PrintWriter(flujoSalidaPadre);
            escritor.print(linea);
            escritor.close();

            try {
                int codigoSalida = proceso.waitFor();

                if (codigoSalida == 0) {
                    InputStream flujoEntrada = proceso.getInputStream();
                    Scanner lector = new Scanner(flujoEntrada);

                    while (lector.hasNextLine()) {
                        System.out.println("Respuesta en mayúsculas: " + lector.nextLine());
                    }

                    lector.close();
                } else {
                    System.out.println("Error al ejecutar el proceso hijo.");
                }
            } catch (InterruptedException ex) {
                System.err.println("Interrupción mientras se esperaba la finalización del proceso.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}