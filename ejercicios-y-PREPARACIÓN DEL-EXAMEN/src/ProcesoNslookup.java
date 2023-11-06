import java.io.*;
import java.util.Scanner;

public class ProcesoNslookup {
    public static void main(String[] args) {
        ProcessBuilder constructorProceso = new ProcessBuilder("nslookup");
        constructorProceso.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try {
            Scanner scanner = new Scanner(System.in);
            String dominio;

            while ((dominio = scanner.nextLine()) != null && dominio.length() > 0) {
                Process proceso = constructorProceso.start();

                OutputStream flujoSalida = proceso.getOutputStream();
                PrintWriter escritor = new PrintWriter(flujoSalida);
                escritor.println(dominio);
                escritor.close();

                try {
                    int codigoSalida = proceso.waitFor();
                    if (codigoSalida == 0) {
                        System.out.println("nslookup se ejecutó exitosamente.");
                    } else {
                        System.out.println("nslookup encontró un error.");
                    }
                } catch (InterruptedException ex) {
                    System.err.println("Interrupción mientras se esperaba la finalización del proceso.");
                }
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}