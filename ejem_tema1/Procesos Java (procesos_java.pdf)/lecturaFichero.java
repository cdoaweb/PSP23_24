/**
 * 
 */
package procesos_java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gabriel
 *
 */
public class lecturaFichero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader("fichero.txt"));
			String linea = reader.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = reader.readLine();
			}
			reader.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
