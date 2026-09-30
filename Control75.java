public class Control75 {
    public static void main(String[] args) {
        int totalMiembros = 5;
        int m = 1;

        System.out.println("=== CLUB CONTRA LA OBESIDAD - CONTROL DE PESO ===");
        
        while (m <= totalMiembros) {
            System.out.println("\n--- Miembro #" + m + " ---");
            System.out.print("Nombre del miembro: ");
            String nombre = System.console().readLine();
            System.out.print("Peso de la ultima reunion (kg): ");
            double pesoAnterior = Double.parseDouble(System.console().readLine());

            double sumaPesos = 0;
            int b = 1;
            
            while (b <= 10) {
                System.out.print("Peso en bascula #" + b + " (kg): ");
                double pesoBascula = Double.parseDouble(System.console().readLine());
                sumaPesos += pesoBascula;
                b++;
            }

            double pesoPromedio = sumaPesos / 10.0;
            double diferencia = pesoPromedio - pesoAnterior;

            System.out.println("\nResultado para " + nombre + ":");
            System.out.printf("Peso anterior: %.2f kg | Peso promedio actual: %.2f kg%n", pesoAnterior, pesoPromedio);

            if (diferencia > 0) {
                System.out.printf("SUBIO %.2f kilos de peso.%n", diferencia);
            } else if (diferencia < 0) {
                System.out.printf("BAJO %.2f kilos de peso.%n", Math.abs(diferencia));
            } else {
                System.out.println("MANTUVO su peso (diferencia de 0.00 kilos).");
            }

            m++;
        }
    }
}
