public class Control60 {
    public static void main(String[] args) {
        char continuar = 'S';
        
        while (continuar == 'S') {
            System.out.println("\n--- INGRESO DE FACTURA ---");
            System.out.print("Numero de factura (num-fac): ");
            String numFac = System.console().readLine();
            System.out.print("Nombre del cliente (num-cli): ");
            String numCli = System.console().readLine();
            System.out.print("Monto de la factura (mon-fac): ");
            double monFac = Double.parseDouble(System.console().readLine());
            System.out.print("Dias transcurridos entre compra y pago: ");
            int dias = Integer.parseInt(System.console().readLine());

            double interesMora = 0;
            double descuentoProntoPago = 0;

            if (dias >= 60) {
                interesMora = monFac * 0.08;
            } else if (dias >= 31 && dias <= 59) {
                interesMora = monFac * 0.06;
            } else if (dias < 15) {
                descuentoProntoPago = monFac * 0.02;
            }

            double montoCancelar = monFac + interesMora - descuentoProntoPago;

            System.out.println("\n--- DETALLE DE FACTURA ---");
            System.out.println("Numero de factura: " + numFac);
            System.out.println("Nombre del cliente: " + numCli);
            System.out.println("Monto de la factura: " + monFac);
            System.out.println("Monto a pagar por interes de mora: " + interesMora);
            System.out.println("Monto descontado por pronto pago: " + descuentoProntoPago);
            System.out.println("Monto total a cancelar: " + montoCancelar);

            System.out.print("\nDesea procesar otra factura? (S/N): ");
            continuar = System.console().readLine().toUpperCase().charAt(0);
        }
    }
}
