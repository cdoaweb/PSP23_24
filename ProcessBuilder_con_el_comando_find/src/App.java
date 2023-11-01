import java.io.IOException;

public class App {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Uso: java App <ruta> <extensión> <tiempo_en_segundos>");
            System.exit(1);
        }

        String ruta = args[0];
        String extension = args[1];
        int tiempoEnSegundos = Integer.parseInt(args[2]);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("find", ruta, "-name", "*." + extension);
            Process procesoHijo = processBuilder.start();

            long tiempoEspera = tiempoEnSegundos * 1000;

            Thread.sleep(tiempoEspera);

            if (procesoHijo.isAlive()) {
                procesoHijo.destroy();
                System.out.println("El proceso hijo ha sido detenido.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}