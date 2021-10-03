/**
 * 
 */
package procesoEjecucion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author gabriel
 *
 */
public class ejecucionSimpleRuntime {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		
		Process out = r.exec("ls -l");
		File fich = new File("fichero2.txt");
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(out.getInputStream()));
		String linea;
		BufferedWriter bw = new BufferedWriter(new FileWriter(fich));
		
		while ((linea = br.readLine())!=null){
			bw.write(linea+"\n");
			System.out.println(linea);
		}
		
		bw.close();
		 	
	}

}
