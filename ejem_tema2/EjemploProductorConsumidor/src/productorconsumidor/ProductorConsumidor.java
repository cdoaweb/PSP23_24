package productorconsumidor;
import java.util.Random;


class Recurso<T>{
    private T valor;

    synchronized public T getValor(){
        T valorDevolver = this.valor;
        this.valor = null;
        return valorDevolver;
    }

    synchronized public void setValor(T v){
        this.valor = v;

    }

    synchronized public boolean datoDisponible(){
        return ( (this.valor!=null) ? true: false);
    }

}

class Hilo extends Thread{
    private String nombre;
    private Recurso rec;
    boolean productor;

    Hilo(String n, Recurso rec, boolean p){
        this.nombre = n;
        this.rec = rec;
        this.productor = p;
    }

    public  void run(){

        while (true){
            if (this.productor){
                    //soy productor
                    synchronized (this.rec){
                        try{
                            while (rec.datoDisponible()){
                                 rec.wait();
                            }
                            //aquí ponemos un valor aleatorio entre 10 y 50;
                            Random r = new Random();
                            int v = r.nextInt(50 - 10 +1 );
                           // Integer valor = v;
                            rec.setValor(v);
                            System.out.println ("Soy el productor con nombre " + this.nombre + " y he productido el valor: " + v);
                            //aquí liberamos a un consumidor.
                            rec.notifyAll();

                        }catch(InterruptedException e){
                            System.out.println("Se ha producido una excepcion");
                        }

                    }  //fin syn
            }else{         
                //soy consumidor   
                
                    synchronized (this.rec){
                        while (!rec.datoDisponible()){
                            try{
                                rec.wait();
                            }catch(InterruptedException e){
                             System.out.println("Se ha producido una excepcion");
                            }
                        } //fin while

                        Integer valor = (Integer)rec.getValor();
                        System.out.println ("Soy el consumidor con nombre " + this.nombre + " y he consumido el valor: " + valor);
                        rec.notifyAll(); //liberamos a un productor
                    } //fin syn
                
            }//fin else
            
        } //fin while
    } //fin run
} //fin clase Hilo


public class ProductorConsumidor {
    public static void main (String argv[]){
        Recurso<Integer> recurso = new Recurso<Integer>();
        Hilo productor1, productor2, consumidor1, consumidor2;
        productor1 = new Hilo("Prod1", recurso, true);
        consumidor1 = new Hilo("Cons1", recurso, false);
        productor2 = new Hilo("Prod2", recurso, true);
        consumidor2 = new Hilo("Cons2", recurso, false);

        System.out.println("Lanzamos un productor y un consumidor que deben sincronizarse ");
        productor1.start();
        consumidor1.start();
        productor2.start();
        consumidor2.start();       

    }
    
}
