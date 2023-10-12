package hilosincrementanvar;

/*
 * Clase Contador
 */
class Contador{
	
	private int conta = 0;
	
	public void incrementaContador(){this.conta++;}
	
	public int getContador(){ return this.conta;}
	
	
}

/*
 * Clase Hilo
 * */
class Hilo implements Runnable{
	/*
	 * Número de hilo, número de incrementos que debe llevar e 
	 * incrementos realizados
	*/
	int numeroHilo;  					
	int cuantoIncremento;				
	int numeroDeIncrementos=0;			
	
	/*Es el contador compartido por cada hilo*/
	private  Contador contador;	
	
	
	/* Constructor */
	Hilo(int nHilo, int cIncremento, Contador conta){
		this.numeroHilo = nHilo; 
		this.cuantoIncremento = cIncremento; 
		this.contador =conta;
	}
	/* Devuelve el número de incrementos que ha hecho */
	public int getNumeroDeIncrementos(){
		return this.numeroDeIncrementos;	
	}


	public void run(){
		
		for (int i=0; i<this.cuantoIncremento; i++){
			contador.incrementaContador();
			this.numeroDeIncrementos++;
		}
		System.out.printf("Hilo con id %s, ha hecho %d incrementos\n", this.numeroHilo, this.getNumeroDeIncrementos());
	}	
}

public class HilosIncrementanVariable{
	private static final int 	NUM_HILOS=10;
	private static final int 	CUENTA_MAXIMA=100000;
	
	public static void main(String argv[]){
		Contador c = new Contador();
		Thread hilos [] = new Thread[NUM_HILOS];
		for (int i=0; i<NUM_HILOS; i++){
			hilos[i] = new Thread(new Hilo(i, CUENTA_MAXIMA/NUM_HILOS, c));
			hilos[i].start();
		}
		
		for (int i=0; i<NUM_HILOS; i++){
			try{
				hilos[i].join();
			}catch(InterruptedException e){
				System.out.println ("Se ha producido una interrupción no deseado\n");
			}
		}
		
		System.out.printf("Desde el hilo principal, se han producido un todal de %d\n", c.getContador());
	}
	
}

