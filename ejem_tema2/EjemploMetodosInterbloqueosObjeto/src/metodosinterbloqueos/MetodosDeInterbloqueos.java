
package metodosinterbloqueos;


class Recurso{
	
	public void bloquear(){
		System.out.println ("Soy el hilo cuyo nombe es "+ Thread.currentThread().getName() + "\n");
		
		synchronized(this){
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

public class MetodosDeInterbloqueos{
	public static void main(String argv[]){
		
		Recurso r1, r2;
		Hilo hilo1, hilo2, hilo3, hilo4;
		
		r1 = new Recurso();
		r2 = new Recurso();
		
		hilo1 = new Hilo(r1);
		hilo2 = new Hilo(r1);
		hilo3 = new Hilo(r2);
		hilo4 = new Hilo(r1);
		
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

/*
public class MetodosDeInterbloqueos implements Runnable{
	
	@Override
	
	public void run(){
		this.bloquear();
		
	}
	
	
	public void bloquear(){
		System.out.println ("Soy el hilo cuyo nombe es "+ Thread.currentThread().getName() + "\n");
		synchronized(this){
			System.out.println (Thread.currentThread().getName() + " Accediendo al recurso \n");
			for (int i=0; i<100000000;i++);
			System.out.println (Thread.currentThread().getName() + " Deja y desbloquea el recurso \n");
		}
		
	}
	
	public static void main(String argv[]){
		
		MetodosDeInterbloqueos r1,r2; 
		Thread hilo1, hilo2, hilo3;
		
		r1 = new MetodosDeInterbloqueos();
		hilo1 = new Thread(r1);
		hilo2 = new Thread(r1);
		
		r2 = new MetodosDeInterbloqueos();
		hilo3 = new Thread(r2);
		
		hilo1.setName("Hilo 1");
		hilo2.setName("Hilo 2");
		hilo3.setName("Hilo 3");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
	
}  //fin de clase
*/


