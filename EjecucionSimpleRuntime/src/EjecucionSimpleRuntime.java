import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class    EjecucionSimpleRuntime {

    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();

        // Comando dir en Windows
        Process out = r.exec("cmd /c dir");
        File fich = new File("fichero.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(out.getInputStream()));
        String linea;
        BufferedWriter bw = new BufferedWriter(new FileWriter(fich));

        while ((linea = br.readLine()) != null) {
            bw.write(linea + "\n");
            System.out.println(linea);
        }

        bw.close();
    }
}