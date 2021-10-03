/**
 * 
 */
package procesos_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gabriel
 *
 */
public class lecturaFlujoEntrada {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader entradaEstandar= new BufferedReader(new InputStreamReader(System.in));
		String mensaje;
		
		System.out.println("Escribe una cadena de texto \n");
		mensaje = entradaEstandar.readLine();
		System.out.println("Mensaje introducido: "+ mensaje +"\n");
	}

}
