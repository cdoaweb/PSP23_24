import java.io.*;
import java.net.*;

public class CalcClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            while (true) {
                System.out.println("Ingrese operación (operando1 operacion operando2) o 'salir' para terminar:");
                userInput = stdIn.readLine();
                if ("salir".equalsIgnoreCase(userInput)) {
                    break;
                }

                out.println(userInput);
                System.out.println("Respuesta del servidor: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se conoce el host 'localhost'");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo obtener E/S para la conexión con localhost");
            System.exit(1);
        }
    }
}