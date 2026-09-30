public class Control53 {
    public static void main(String[] args) {
        System.out.print("Ingrese el numero de empleados (M): ");
        int m = Integer.parseInt(System.console().readLine());
        int i = 1;

        int venTipo1 = 0;
        int venTipo2 = 0;
        int venTipo3 = 0;
        int extranjerosEdadImpar = 0;
        double sumaEdades = 0;
        double totalGeneralPagar = 0;
        
        while (i <= m) {
            System.out.println("\nEmpleado " + i + ":");
            System.out.print("Nombre: ");
            String nombre = System.console().readLine();
            System.out.print("Nacionalidad (V o E): ");
            char nac = System.console().readLine().toUpperCase().charAt(0);
            System.out.print("Edad: ");
            int edad = Integer.parseInt(System.console().readLine());
            System.out.print("Tipo de empleado (1, 2 o 3): ");
            int tipo = Integer.parseInt(System.console().readLine());
            System.out.print("Horas trabajadas: ");
            double horas = Double.parseDouble(System.console().readLine());

            double pagoHora = 0;
            if (tipo == 1) {
                pagoHora = 5000;
                if (nac == 'V') {
                    venTipo1++;
                }
            } else if (tipo == 2) {
                pagoHora = 10000;
                if (nac == 'V') {
                    venTipo2++;
                }
            } else if (tipo == 3) {
                pagoHora = 15000;
                if (nac == 'V') {
                    venTipo3++;
                }
            }

            double sueldoBasico = horas * pagoHora;
            double seguroSocial = 0;
            if (sueldoBasico > 100000) {
                seguroSocial = sueldoBasico * 0.03;
            }
            double sueldoNeto = sueldoBasico - seguroSocial;

            if (nac == 'E' && (edad % 2 != 0)) {
                extranjerosEdadImpar++;
            }

            sumaEdades += edad;
            totalGeneralPagar += sueldoNeto;

            System.out.println("a. Sueldo basico o bruto: " + sueldoBasico + " Bs.");
            System.out.println("b. Seguro Social: " + seguroSocial + " Bs.");
            System.out.println("   Sueldo neto: " + sueldoNeto + " Bs.");

            i++;
        }

        System.out.println("\n--- TOTALES Y ESTADISTICAS ---");
        System.out.println("c. Venezolanos tipo 1: " + venTipo1);
        System.out.println("   Venezolanos tipo 2: " + venTipo2);
        System.out.println("   Venezolanos tipo 3: " + venTipo3);
        System.out.println("d. Total de extranjeros con edad impar: " + extranjerosEdadImpar);
        if (m > 0) {
            System.out.printf("e. Promedio de edad de todos los empleados: %.2f%n", (sumaEdades / m));
        }
        System.out.println("f. Total general a pagar en sueldos: " + totalGeneralPagar + " Bs.");
    }
}
