import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            InetAddress address = InetAddress.getByName("localhost");
            int port = 12345;

            String message = "Hola, soy Carlos y quiero saludarle";
            byte[] sendMessage = message.getBytes();
            DatagramPacket request = new DatagramPacket(sendMessage, sendMessage.length, address, port);
            socket.send(request);

            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            String received = new String(response.getData(), 0, response.getLength());

            System.out.println("Respuesta del servidor: " + received);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}