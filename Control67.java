public class Control67 {
    public static void main(String[] args) {
        double deudaInicial = 12775.0;
        double saldo = deudaInicial;
        double pagoActual = 100.0;
        int numPagos = 0;
        double montoUltimoPago = 0;

        System.out.printf("%-10s %-15s %-20s%n", "No. Pago", "Monto Pago (Bs.)", "Saldo Pendiente (Bs.)");
        System.out.println("--------------------------------------------------");
        
        while (saldo > 0.0001) {
            numPagos++;
            double pagoEfectuado = pagoActual;
            if (pagoEfectuado > saldo) {
                pagoEfectuado = saldo;
            }
            saldo -= pagoEfectuado;
            montoUltimoPago = pagoEfectuado;

            System.out.printf("%-10d %-15.2f %-20.2f%n", numPagos, pagoEfectuado, saldo);
            pagoActual += 125.0;
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Numero de pagos realizados: " + numPagos);
        System.out.printf("Monto del ultimo pago: %.2f Bs.%n", montoUltimoPago);
    }
}
