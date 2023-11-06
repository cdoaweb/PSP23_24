import java.util.Scanner;

public class ConvertirMayusculas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linea = scanner.nextLine();
        String mayusculas = linea.toUpperCase();
        System.out.println(mayusculas);
    }
}