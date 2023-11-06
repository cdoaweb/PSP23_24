import java.io.*;
import java.util.Scanner;

public class ConvertirMayusculasPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce dos líneas:");

        try {
            ProcessBuilder procesoBuilder = new ProcessBuilder("java", "-cp", "convertir.jar", "ConvertirMayusculas");
            for (int i = 0; i < 2; i++) {
                String linea = scanner.nextLine();
                Process proceso = procesoBuilder.start();

                try (OutputStream flujoSalidaPadre = proceso.getOutputStream();
                     PrintWriter escritor = new PrintWriter(flujoSalidaPadre)) {
                    escritor.println(linea);
                }

                try {
                    int codigoSalida = proceso.waitFor();

                    if (codigoSalida == 0) {
                        try (InputStream flujoEntrada = proceso.getInputStream();
                             Scanner lector = new Scanner(flujoEntrada)) {
                            while (lector.hasNextLine()) {
                                System.out.println("Respuesta en mayúsculas: " + lector.nextLine());
                            }
                        }
                    } else {
                        System.out.println("Error al ejecutar el proceso hijo.");
                    }
                } catch (InterruptedException ex) {
                    System.err.println("Interrupción mientras se esperaba la finalización del proceso.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}