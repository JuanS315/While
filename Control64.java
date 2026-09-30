public class Control64 {
    public static void main(String[] args) {
        double meta = 1.99;
        double suma = 0.0;
        double termino = 1.0;
        int n = 0;

        int mejorN = 0;
        double mejorSuma = 0.0;
        double menorDif = 999.0;
        int continuar = 1;
        
        while (continuar == 1) {
            n++;
            suma += termino;
            double difActual = Math.abs(meta - suma);
            if (difActual < menorDif) {
                menorDif = difActual;
                mejorN = n;
                mejorSuma = suma;
            }
            termino = termino / 2.0;
            if (suma > meta && difActual > menorDif) {
                continuar = 0;
            }
        }

        System.out.println("Numero de terminos necesarios: " + mejorN);
        System.out.printf("Valor de la suma mas proxima a 1.99: %.8f%n", mejorSuma);
    }
}
