/**
 * 
 */
package procesoEjecucion;

import java.io.File;
import java.io.IOException;

/**
 * @author gabriel
 *
 */
public class ejecucionSimple {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("ls","-l");
		
		pb.redirectOutput(new File("fichero.txt"));
		
		pb.start();
	}

}
