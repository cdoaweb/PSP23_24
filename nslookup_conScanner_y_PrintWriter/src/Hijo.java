import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) {
        try {
            // Obtenemos la entrada del padre
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Procesamos los dominios recibidos del padre
            System.out.println("Dominios recibidos:");
            String dominio;
            while ((dominio = br.readLine()) != null) {
                System.out.println(dominio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}