import java.io.*;

public class hijoPadre {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ls","-l");

        Process p = pb.start();

        InputStreamReader ir = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(ir);
        String linea;

        while ((linea = br.readLine())!= null){
            System.out.println(linea);
        }

    }
}
