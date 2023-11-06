import java.io.*;
import java.util.Scanner;

public class NslookupProcessWithoutRedirection {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("nslookup");

        try {
            Scanner scanner = new Scanner(System.in);
            String dominio;

            while ((dominio = scanner.nextLine()) != null && dominio.length() > 0) {
                Process proceso = processBuilder.start();

                OutputStream flujoSalida = proceso.getOutputStream();
                PrintWriter escritor = new PrintWriter(flujoSalida);
                escritor.println(dominio);
                escritor.close();

                try {
                    int codigoSalida = proceso.waitFor();
                    if (codigoSalida == 0) {
                        InputStream flujoEntrada = proceso.getInputStream();
                        Scanner lector = new Scanner(flujoEntrada);

                        while (lector.hasNextLine()) {
                            System.out.println(lector.nextLine());
                        }

                        lector.close();
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