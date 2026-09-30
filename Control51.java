public class Control51 {
    public static void main(String[] args) {
        int a1 = 6;
        int d = 5;
        int n = 12;
        int repeticion = 1;
        int termino = a1;
        int suma = 0;
        int a12 = 0;
        
        while (repeticion <= n) {
            suma += termino;
            if (repeticion == n) {
                a12 = termino;
            }
            termino += d;
            repeticion++;
            System.out.println("Termino " + repeticion + ": " + termino);
        }

        System.out.println("Termino doceavo (a12): " + a12);
        System.out.println("Suma de los doce primeros terminos: " + suma);
    }
}