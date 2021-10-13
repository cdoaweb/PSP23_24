
package evitainterpororden;


class CuentaBancaria{
	
	int saldo;
	final String numeroCuenta;
	
	CuentaBancaria (int saldo, String nCuenta){
		this.saldo = saldo;
		this.numeroCuenta = nCuenta;
	}
	
	public synchronized void sacarCantidad (int cantidad){
		this.saldo -= cantidad;
	}
	
	public synchronized void ingresarCantidad (int cantidad){
		this.saldo += cantidad;
	}
	
	public int getSaldo(){
		return this.saldo;
	}
	
	public String getNumeroCuenta(){
		return this.numeroCuenta;
	}
	
	@Override
	public String toString(){
		return "Saldo actual de la cuenta " + this.numeroCuenta + " es de " + this.saldo + "\n"; 
	}
	
}  //fin cuentaBancaria

/*
 * Clase que pone orden de trasferencia
 * desde la cuenta cuyo número cuenta
 * es por orden la menor.
 * Si no se puede, no efectuará la trasferencia
 * */
class GestorTransferencias{
	
	
	public static boolean transferencia(CuentaBancaria c1, CuentaBancaria c2, int cantidad){
		CuentaBancaria cuentaOrdenMenor, cuentaOrdenMayor;
		
		if (c1.getNumeroCuenta().compareTo(c2.getNumeroCuenta()) <0 ){
			//por orden la cuenta1 está antes que c2
			cuentaOrdenMenor = c1;
			cuentaOrdenMayor = c2;
		//	System.out.println("C1 es menor que C2\n");
		}else{
			cuentaOrdenMenor = c2;
			cuentaOrdenMayor = c1;
		//	System.out.println("C2 es menor que C1\n");
		}
		
		synchronized (cuentaOrdenMenor){
			synchronized (cuentaOrdenMayor){
				if (cuentaOrdenMenor.getSaldo() >= cantidad){
					cuentaOrdenMenor.sacarCantidad(cantidad);
					cuentaOrdenMayor.ingresarCantidad(cantidad);
					return true;
				}
				return false;  //no hay saldo suficiente en la cuenta Menor
			}
		}
		
	}	
	
}//fin GestorTrasferencias

class Hilo extends Thread{
	
	CuentaBancaria cuenta1, cuenta2;
	
	
	Hilo(CuentaBancaria c1, CuentaBancaria c2){
		this.cuenta1 = c1;
		this.cuenta2 = c2;
	}
	
	@Override
	public void run(){
		
		int cantidadATransferir = 10;
		int numTransferencias = 0;
		for (int i=0; i<1000; i++){
			if (GestorTransferencias.transferencia(cuenta1, cuenta2, cantidadATransferir))
				numTransferencias++;
		}
		
		String msg = "Fin transferencia de la cuenta " + this.cuenta1.getNumeroCuenta();
			msg+=" a la cuenta " + this.cuenta2.getNumeroCuenta();
			msg+=" Realizada por el hilo " + this.getName();
			msg+=" por " + numTransferencias + " realizadas\n";
		System.out.println(msg);
	}
}  //fin de la clase Hilo


public class TransferenciaSinBloqueo{
	public static void main (String arg[]){
		Hilo h1, h2;
		CuentaBancaria c1, c2;
		
		c1 = new CuentaBancaria(13000, "ES92233223323244563");
		c2 = new CuentaBancaria(80000, "ES21599598685884858");
		
		h1 = new Hilo(c1, c2);
		h2 = new Hilo(c2, c1);
		h1.setName("Hilo1");
		h2.setName("Hilo2");
		
		h1.start();
		h2.start();
		
		try{
			h1.join();
			h2.join();
			System.out.println ("Todas las transacciones han finalizado\n");
			System.out.println (c1);
			System.out.println (c2);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
