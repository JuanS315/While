public class Control55 {
    public static void main(String[] args) {
        int k = 1;
        double suma = 0;
        int terminos = 0;
        int continuar = 1;
        
        while (continuar == 1) {
            double termino = ((double) (k * k + 1)) / k;
            if (suma + termino <= 1000.0) {
                suma += termino;
                terminos = k;
                k++;
            } else {
                continuar = 0;
            }
        }

        System.out.println("Numero de terminos necesarios: " + terminos);
        System.out.printf("Valor alcanzado de la sumatoria: %.4f%n", suma);
    }
}
