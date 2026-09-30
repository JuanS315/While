public class Control57 {
    public static void main(String[] args) {
        double n = 0;
        
        while (n <= 0) {
            System.out.print("Ingrese un numero positivo N: ");
            n = Double.parseDouble(System.console().readLine());
            if (n <= 0) {
                System.out.println("El numero debe ser estrictamente positivo.");
            }
        }

        double x = 0.1;
        double rn = 0;
        double dif = 0;
        
        while (dif >= 0.000001) {
            rn = (x + (n / x)) / 2.0;
            dif = Math.abs(x - rn);
            x = rn;
        }

        System.out.printf("La raiz cuadrada calculada de %.6f es: %.6f%n", n, rn);
    }
}
