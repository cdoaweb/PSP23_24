import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // Verificar el número de argumentos
        if (args.length != 1) {
            System.out.println("Uso: java ListFilesInDirectoryWindows <directorio>");
            System.exit(1);
        }

        // Obtener el directorio pasado como argumento
        String directoryPath = args[0];
        try {
            // Crear un proceso para ejecutar el comando "dir" en el directorio
            Process process = Runtime.getRuntime().exec("cmd /c dir" + directoryPath);

            // Capturar la salida del proceso hijo
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            System.out.println("Contenido del directorio " + directoryPath + ":");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso hijo termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Proceso hijo terminado exitosamente.");
            } else {
                System.out.println("Proceso hijo terminado con código de salida " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}