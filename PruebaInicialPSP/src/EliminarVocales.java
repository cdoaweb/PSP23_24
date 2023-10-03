import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EliminarVocales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese texto (presione Enter para finalizar):");
        String texto = scanner.nextLine();

        String textoSinVocales = eliminarVocales(texto);

        try {
            FileWriter fileWriter = new FileWriter("/tmp/texto.txt");
            fileWriter.write(textoSinVocales);
            fileWriter.close();
            System.out.println("El texto sin vocales se ha guardado en /tmp/texto.txt");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public static String eliminarVocales(String texto) {
        String textoSinVocales = "";
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (!esVocal(caracter)) {
                textoSinVocales += caracter;
            }
        }
        return textoSinVocales;
    }

    public static boolean esVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);
        return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
    }
}