public class CuentaBancaria {
    private String iban;
    private double saldo;

    public CuentaBancaria(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public synchronized void ingresarSaldo(double cantidad) {
        saldo += cantidad;
    }

    public synchronized void sacarSaldo(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= cantidad;
        }
    }
}