import java.io.*;
import java.net.*;
import java.util.Date;

public class CalcServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor iniciado. Esperando clientes...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Operación recibida: " + inputLine);
                        String outputLine = processOperation(inputLine);
                        out.println(outputLine);
                    }
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port 5000 or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 5000 or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    private static String processOperation(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length != 3) {
            return "Formato de operación inválido.";
        }

        try {
            double op1 = Double.parseDouble(parts[0]);
            String operation = parts[1];
            double op2 = Double.parseDouble(parts[2]);
            double result;

            switch (operation) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    if (op2 == 0) throw new ArithmeticException("División por cero.");
                    result = op1 / op2;
                    break;
                default:
                    return "Operación desconocida.";
            }

            return String.format("(%s) res:%.2f", new Date(), result);
        } catch (NumberFormatException e) {
            return "Error al parsear números.";
        } catch (ArithmeticException e) {
            return String.format("(%s) res:err", new Date());
        }
    }
}