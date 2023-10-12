package interrupcionhilos;

class HiloInterrumpible extends Thread{
    String nombre; 

    HiloInterrumpible(String n){
        this.nombre = n;
    }

    @Override
    public void run(){

        try{

            /*
            Me interrumpo por 1 segundo.
            Desde el main, seguro que me mandan una interrupción mientras duermo !!!!.
            */
            System.out.printf ("Soy el hilo %s%n", this.nombre);
            Thread.sleep(1000);  
        }catch(InterruptedException e){
            System.out.println ("Acabo de interrumpir al hilo Interrumpible");
        }
    }
} //fin clase HiloInterrumpible

class HiloNoInterrumpible extends Thread {
    String nombre;

    HiloNoInterrumpible(String n){
        this.nombre = n;
    }

    @Override
    public void run (){
        //cuando recibamos una señal de interrupción, la capturamos.
        while (!Thread.currentThread().isInterrupted()){  
            for (long i=0; i< 1000000000L; i++){

            }
            System.out.printf ("Soy el hilo %s%n", this.nombre);
        }
        System.out.println ("Me acaban de interrumpir, la he capturdo y me salgo del while, jaaaa");
        
    }
}


public class InterrupcionDeHilos {

    public static void main(String[] args) {
        try{
            HiloInterrumpible h1 = new HiloInterrumpible("Hilo huevon");
            HiloNoInterrumpible h2 = new HiloNoInterrumpible("Hilo guay");
            h1.start();
            h2.start();
            Thread.sleep(300);  //como hilo principal, me duermo 300 msg.
            h1.interrupt();
            h2.interrupt();
    
        }catch(InterruptedException e){
            System.out.println ("Soy el hilo principal y me acaban de interrumpir....");
        }
        
    }
    
    
    
}
