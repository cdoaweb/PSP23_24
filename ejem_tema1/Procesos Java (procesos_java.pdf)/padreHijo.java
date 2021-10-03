import javax.sound.midi.SysexMessage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.StandardSocketOptions;
import java.util.Scanner;

public class padreHijo {

    private static void cambiarFecha(Process p, String date) throws IOException {
        OutputStream os = p.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(date);
        System.out.println("LA nueva fecha es:"+date);

    }
    public static void main(String[] args) throws IOException, IOException, InterruptedException {
        Scanner sc;
        sc = new Scanner(System.in);
        String fecha;

        System.out.println("Escribe la fecha");
        fecha = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("date");
        Process p = pb.start();
        cambiarFecha(p,fecha);
        p.waitFor();

    }


}
