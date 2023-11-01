import java.io.*;
import java.util.Scanner;

public class Redireccion {

    public static void main(String[] args) {
        try {

            ProcessBuilder procesoHijo = new ProcessBuilder("java", "Hijo");
            procesoHijo.redirectErrorStream(true); // Redirige el error al flujo de salida

            Process hijo = procesoHijo.start();

            // Obtenemos el OutputStream del proceso hijo
            OutputStream os = hijo.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa dominios (escribe 'exit' para salir):");

            // Pasamos los dominios al proceso hijo
            String dominio;
            while (!(dominio = scanner.nextLine()).equals("exit")) {
                pw.println(dominio);
                pw.flush();
            }

            // Cerramos el flujo de entrada del hijo
            pw.close();

            // Mostramos la salida del hijo en el padre
            InputStream is = hijo.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Salida del hijo: " + linea);
            }

            hijo.waitFor();
            System.out.println("Proceso hijo finalizado.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}