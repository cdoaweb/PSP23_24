
package metodosinterbloqueos;

/*
 * También se consideraría con método estático
 * */
class Recurso{
	
	public void bloquear(){
		System.out.println ("Soy el hilo cuyo nombe es "+ Thread.currentThread().getName() + "\n");
		
		synchronized(Recurso.class){
			System.out.println (Thread.currentThread().getName() + " Accediendo al recurso y bloqueado \n");
			for (int i=0; i<100000000;i++);
			System.out.println (Thread.currentThread().getName() + " Deja y desbloquea el recurso \n");
		}
		
	}
	
}

class Hilo extends Thread{
	
	private Recurso objeto;
	
	Hilo (Recurso obj){
		this.objeto = obj;
	}
	
	public void run(){
		this.objeto.bloquear();
		
	}
}

public class MetodosDeInterbloqueosClase{
	public static void main(String argv[]){
		
		Recurso r1, r2, r3, r4;
		Hilo hilo1, hilo2, hilo3, hilo4;
		
		r1 = new Recurso();
		r2 = new Recurso();
		r3 = new Recurso();
		r4 = new Recurso();
		
		hilo1 = new Hilo(r1);
		hilo2 = new Hilo(r2);
		hilo3 = new Hilo(r3);
		hilo4 = new Hilo(r4);
		
		hilo1.setName("Hilo 1");
		hilo2.setName("Hilo 2");
		hilo3.setName("Hilo 3");
		hilo4.setName("Hilo 4");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		
	}
	
}
