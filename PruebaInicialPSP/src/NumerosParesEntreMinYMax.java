public class NumerosParesEntreMinYMax   {
    private int min;        
    private int max;

    // Constructor
    public NumerosParesEntreMinYMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // Método público para obtener los números pares entre min y max
    public void encontrarNumerosPares() {
        if (min % 2 != 0) {
            // Si min es impar, aumentamos en 1 para empezar con un número par
            min++;
        }

        System.out.println("Números pares entre " + min + " y " + max + ":");

        for (int i = min; i <= max; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println(); // Salto de línea al final
    }

    public static void main(String[] args) {
        NumerosParesEntreMinYMax numerosPares = new NumerosParesEntreMinYMax(10, 60);
        numerosPares.encontrarNumerosPares();
    }
}