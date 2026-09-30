public class Control65 {
    public static void main(String[] args) {
        char resp = 'S';
        
        while (resp == 'S') {
            System.out.println("\n--- REGISTRO DE TRABAJADOR ---");
            System.out.print("Nombre: ");
            String nombre = System.console().readLine();
            System.out.print("Cedula: ");
            String cedula = System.console().readLine();
            System.out.print("Tipo (1=Obrero, 2=Administrativo, 3=Ejecutivo): ");
            int tipo = Integer.parseInt(System.console().readLine());
            System.out.print("Cantidad de hijos: ");
            int hijos = Integer.parseInt(System.console().readLine());
            System.out.print("Dias asistidos en el mes (de 30): ");
            int diasAsistidos = Integer.parseInt(System.console().readLine());

            double sueldoBasico = 0;
            if (tipo == 1) {
                sueldoBasico = 100000;
            } else if (tipo == 2) {
                sueldoBasico = 165500;
            } else if (tipo == 3) {
                sueldoBasico = 250000;
            }

            int hijosValidos = hijos;
            if (hijosValidos > 5) {
                hijosValidos = 5;
            }
            if (hijosValidos < 0) {
                hijosValidos = 0;
            }

            double aporteHijos = sueldoBasico * 0.10 * hijosValidos;
            double aporteAsistencia = 0;
            if (diasAsistidos > 28.5) {
                aporteAsistencia = sueldoBasico * 0.05;
            }

            double deduccionCaja = sueldoBasico * 0.10;
            double deduccionSeguro = sueldoBasico * 0.02;

            double sueldoNeto = sueldoBasico + aporteHijos + aporteAsistencia - deduccionCaja - deduccionSeguro;

            System.out.println("\n--- REGISTRO SALARIAL ---");
            System.out.println("Nombre: " + nombre);
            System.out.println("Cedula: " + cedula);
            System.out.printf("Sueldo Basico: %.2f Bs.%n", sueldoBasico);
            System.out.printf("Aporte por Hijos: %.2f Bs.%n", aporteHijos);
            System.out.printf("Aporte por Asistencia: %.2f Bs.%n", aporteAsistencia);
            System.out.printf("Aporte a la Caja de Ahorros: %.2f Bs.%n", deduccionCaja);
            System.out.printf("Seguro Social: %.2f Bs.%n", deduccionSeguro);
            System.out.printf("Sueldo Neto: %.2f Bs.%n", sueldoNeto);

            System.out.print("\nDesea procesar otro trabajador? (S/N): ");
            resp = System.console().readLine().toUpperCase().charAt(0);
        }
    }
}
