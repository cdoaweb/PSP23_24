package interbloqueohilos;
/*
 * Ejemplo de un interbloqueo forzado
 * entre dos hilos.
 * */
 
 

class Interbloqueo{
	private Object objeto1 = new Object();
	private Object objeto2 = new Object();
	
	public void accesoOrdenObjeto1Y2(){
		try{
			synchronized (objeto1){
				Thread.sleep(2000);
				synchronized (objeto2){
					System.out.println("Acceso a recurso por orden 1 y 2, finalizado\n");
				}
			}
				
				
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void accesoOrdenObjeto2Y1(){
		try{
			synchronized (objeto2){
				Thread.sleep(2000);
				synchronized (objeto1){
					Thread.sleep(2000);
					System.out.println("Acceso a recurso por orden 2 y 1, finalizado\n");
				}
			}
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
} //fin de clase Interbloqueo




class Hilo implements Runnable{
	private Interbloqueo bloqueo;
	private int numHilo;
	
	public Hilo(Interbloqueo b, int h){
		this.bloqueo = b;
		this.numHilo = h;
	}
	
	@Override
	public void run(){
		if (this.numHilo==1)
			bloqueo.accesoOrdenObjeto1Y2();
		else
			bloqueo.accesoOrdenObjeto2Y1();
		
	}
	
	
} //fin de Hilo


public class InterbloqueoHilos{
	public static void main (String argv[]){
		System.out.println ("Voy a bloquear a dos hilos al acceso a un recurso\n");
		Interbloqueo objetoQueBloquea = new Interbloqueo();
		Thread h1 = new Thread(new Hilo(objetoQueBloquea, 1));
		Thread h2 = new Thread(new Hilo(objetoQueBloquea, 2));
		h1.start();
		h2.start();
		try{
			h1.join();
			h2.join();
			System.out.println("Este mensaje nunca saldrá\n");
		}catch(InterruptedException e){
				e.printStackTrace();
		}
	}
} //fin de InterbloqueoHilos
