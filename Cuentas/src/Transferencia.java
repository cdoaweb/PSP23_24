public class Transferencia {
    public static void transferir(CuentaBancaria cuenta1, CuentaBancaria cuenta2, double cantidad) {
        synchronized (cuenta1) {
            synchronized (cuenta2) {
                cuenta1.sacarSaldo(cantidad);
                cuenta2.ingresarSaldo(cantidad);
            }
        }
    }
}