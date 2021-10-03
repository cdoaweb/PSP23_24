import java.io.*;

public class nslookup {

    public static void main(String[] args) throws UnsupportedEncodingException {
        ProcessBuilder pb = new ProcessBuilder("nslookup");
        //envia la salida de datos del proceso a la salida estándar heredada
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try(//convierto en flujo de bytes en caracteres
                InputStreamReader isstdin = new InputStreamReader(System.in, "UTF-8");
            //preparo el buffer para leer de la entrada estándar
            BufferedReader brstdin = new BufferedReader(isstdin)) {

            String linea;
            System.out.println("Introducir nombre de dominio");
            while (((linea = brstdin.readLine()) != null) && (linea.length() != 0)){
                Process p = pb.start();
                try (
                    //preparo el tunel entre el padre y el hijo, para mandar datos del proceso padre al hijo
                    OutputStream osp = p.getOutputStream();
                    //convierto flujo de caracteres en byte
                    OutputStreamWriter oswp = new OutputStreamWriter(osp, "UTF-8")){
                        //escribo el dominio solicitado en el proceso padre en el flujo de entrada del hijo
                        oswp.write(linea);
                }
                try{
                    p.waitFor();
                } catch ( InterruptedException ex) {}
                System.out.println("Introducir nombre de dominio");
                }
        }catch (IOException e){
            System.out.println("ERROR: de E/S");
            e.printStackTrace();
        }
    }
}
