package contadorconestado;

import java.util.Random;




/*
Clase de exclusión mutua.
Todos los hilos deben compartir este objeto.
*/

class ContadorEstado {
    private int contador;

    ContadorEstado(int v){contador = v;}

    synchronized int getContador(){return contador;}

    synchronized void incrementaContador(){
        contador++;
    }

    synchronized void decrementaContador(){
        contador--;
    }

}


/*
Clase Hilo de ejecución.
*/

class Hilo extends Thread{
    private String nombre;
    private boolean tipo;
    private ContadorEstado recurso;

    Hilo (String n, boolean t, ContadorEstado rec){
        nombre = n;
        tipo = t;
        recurso = rec;
    }

    public String getNombre(){return nombre;}
    public boolean getTipo(){ return tipo;}
    
    @Override
    public String toString(){
        String res = "Soy el hilo cuyo nombre es " + nombre;
            if (tipo)
                res+=" Incremento el contador";
            else   
                res+=" Decremento el contador";
            return res;
    }




    @Override
    public void run(){
        if (this.tipo){
            //se trata de un hilo que incrementa
          //  while (true){
                synchronized(recurso){
                    if (recurso.getContador()==10){
                        try {
                            //debo bloquearme.
                            
                            System.out.println("Debo esperarme a que alguien lo decremente\n");
                            recurso.wait();
                            
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    recurso.incrementaContador(); //ya puedo incrementarlo
                    System.out.println("Acabo de incrementar el contador en "+recurso.getContador());
                    
                    recurso.notify();
                    
                    
                }
         //   }
        }
        else{
            //se trata de un hilo que decrementa
           // while (true){  //siempre voy a decrementar
                synchronized(recurso){
                    if (recurso.getContador()==0){
                        try {
                            System.out.println ("Debo esperarme a que alquien lo incremente");
                            recurso.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    recurso.decrementaContador();
                    System.out.println("Acabo de decrementar el contador en "+recurso.getContador());

                    
                    recurso.notify();
                }
    
    
         //   }
        }

    }

}

public class ContadorConEstado{

    public static void main(String[] args) {
        System.out.println("Voy a crear 100 hilos de ejecución");   
        Hilo hilos[] = new Hilo[100]; 
        ContadorEstado conta = new ContadorEstado(0);
        Random r = new Random();
        boolean valorDado;

        for (int i=0; i<100; i++){
            valorDado = r.nextBoolean();
            hilos[i] = new Hilo("Hilo "+i, valorDado, conta);
            hilos[i].start();
        }

        for (int i=0; i<100; i++){
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}