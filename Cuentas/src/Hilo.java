import java.util.Random;

public class Hilo implements Runnable {
    private String nombre;
    private CuentaBancaria cuenta1;
    private CuentaBancaria cuenta2;

    public Hilo(String nombre, CuentaBancaria cuenta1, CuentaBancaria cuenta2) {
        this.nombre = nombre;
        this.cuenta1 = cuenta1;
        this.cuenta2 = cuenta2;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            double cantidad = 10;
            Transferencia.transferir(cuenta1, cuenta2, cantidad);
            System.out.println(nombre + " realizó una transferencia de " + cantidad + " euros");
            try {
                Thread.sleep(rand.nextInt(10)); // Simula un procesamiento aleatorio
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}