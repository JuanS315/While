public class Control58 {
    public static void main(String[] args) {
        System.out.print("Ingrese el capital a depositar: ");
        double capital = Double.parseDouble(System.console().readLine());
        System.out.print("Ingrese la tasa de interes anual (%): ");
        double tasa = Double.parseDouble(System.console().readLine());
        System.out.print("Ingrese la duracion del deposito en semanas: ");
        int semanas = Integer.parseInt(System.console().readLine());

        int totalDias = semanas * 7;
        int dia = 1;
        double interesDiario = (tasa / 100.0 * capital) / 365.0;
        double capitalAcumulado = capital;

        if (totalDias > 0) {
            
            while (dia <= totalDias) {
                capitalAcumulado += interesDiario;
                dia++;
            }
        }

        System.out.println("\n--- RESULTADO DE LA INVERSION ---");
        System.out.println("Total de dias transcurridos: " + totalDias);
        System.out.printf("Interes diario generado: %.4f%n", interesDiario);
        System.out.printf("Capital total acumulado: %.2f%n", capitalAcumulado);
    }
}
