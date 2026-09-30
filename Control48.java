public class Control48 {
    public static void main(String[] args) {
        System.out.printf("%-12s %-12s %-12s %-12s%n", "Fahrenheit", "Celsius", "Kelvin", "Rankine");
        System.out.println("--------------------------------------------------");
        System.out.println("Muestra 1 (28 a 54 F, paso 1 F):");
        double f = 28.0;
        
        while (f <= 54.0001) {
            double c = 5.0 * (f - 32.0) / 9.0;
            double r = f + 459.67;
            double k = c + 273.15;
            System.out.printf("%-12.2f %-12.2f %-12.2f %-12.2f%n", f, c, k, r);
            f += 1.0;
        }

        System.out.println("\nMuestra 2 (450 a 950 F, paso 50 F):");
        f = 450.0;
        
        while (f <= 950.0001) {
            double c = 5.0 * (f - 32.0) / 9.0;
            double r = f + 459.67;
            double k = c + 273.15;
            System.out.printf("%-12.2f %-12.2f %-12.2f %-12.2f%n", f, c, k, r);
            f += 50.0;
        }

        System.out.println("\nMuestra 3 (-50 a 250 F, paso 10 F):");
        f = -50.0;
        
        while (f <= 250.0001) {
            double c = 5.0 * (f - 32.0) / 9.0;
            double r = f + 459.67;
            double k = c + 273.15;
            System.out.printf("%-12.2f %-12.2f %-12.2f %-12.2f%n", f, c, k, r);
            f += 10.0;
        }
    }
}
