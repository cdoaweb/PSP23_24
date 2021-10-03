/**
 * 
 */
package procesos_java;

import java.io.IOException;

/**
 * @author gabriel
 *
 */
public class primerEjemplo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int c;
		int contador = 0;
		//leer hasta encontrar el final de linea
		while((c = System.in.read()) != '\n') {
			contador++;
			System.out.println((char)c);
		}
		System.out.println();
		System.out.println("Contados " + contador + "bytes leidos");
	}

}
