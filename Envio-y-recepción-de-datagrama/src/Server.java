import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            
            socket = new DatagramSocket(12345);
            byte[] buffer = new byte[1024];

            while (true) {
                System.out.println("Servidor esperando mensajes...");

                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                String message = new String(request.getData(), 0, request.getLength());

                System.out.println("Mensaje recibido: " + message);
                String responseMessage = "Muchas gracias, yo también le saludo a usted.";
                byte[] responseData = responseMessage.getBytes();
                DatagramPacket response = new DatagramPacket(responseData, responseData.length, request.getAddress(), request.getPort());
                socket.send(response);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}