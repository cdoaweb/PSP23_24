public class App {
    public static void main(String[] args) throws Exception {
        CuentaBancaria cuenta1 = new CuentaBancaria("ES123456789", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("ES987654321", 1000);

        Thread hilo1 = new Thread(new Hilo("Hilo1", cuenta1, cuenta2));
        Thread hilo2 = new Thread(new Hilo("Hilo2", cuenta2, cuenta1));

        hilo1.start();
        hilo2.start();
    }
}