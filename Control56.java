public class Control56 {
    public static void main(String[] args) {
        System.out.print("Ingrese el dividendo: ");
        int dividendo = Integer.parseInt(System.console().readLine());
        System.out.print("Ingrese el divisor (positivo): ");
        int divisor = Integer.parseInt(System.console().readLine());

        if (divisor <= 0 || dividendo < 0) {
            System.out.println("Entrada invalida. Divisor debe ser mayor que 0.");
        } else {
            int cociente = 0;
            int resto = dividendo;

            if (resto >= divisor) {
                
                while (resto >= divisor) {
                    System.out.println(resto + " - " + divisor + " = " + (resto - divisor));
                    resto = resto - divisor;
                    cociente++;
                }
            }

            System.out.println("Cociente obtenido: " + cociente);
            System.out.println("Resto de la division: " + resto);
        }
    }
}
