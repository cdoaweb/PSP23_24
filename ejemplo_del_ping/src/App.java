import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        try {
            Process procesoHijo;
            if (sistemaOperativo.contains("win")) {
                // Para Windows, el padre esperará a que el hijo termine (4 pings)
                procesoHijo = new ProcessBuilder("ping", "8.8.8.8", "-n", "4").start();
                procesoHijo.waitFor();
                System.out.println("El proceso hijo en Windows ha finalizado.");
            } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")
                    || sistemaOperativo.contains("mac")) {
                // Para Linux, el padre mostrará 10 pings y luego matará al hijo
                procesoHijo = new ProcessBuilder("ping", "8.8.8.8").start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
                String linea;
                int contador = 0;
                while ((linea = reader.readLine()) != null && contador < 10) {
                    System.out.println(linea);
                    contador++;
                }

                if (procesoHijo.isAlive()) {
                    procesoHijo.destroy();
                    System.out.println("El proceso hijo en Linux ha sido detenido después de 10 pings.");
                }
            } else {
                System.out.println("Sistema operativo no compatible.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
