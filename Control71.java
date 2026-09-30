public class Control71 {
    public static void main(String[] args) {
        int totalHuerfanos = 0;
        int huerfanosTachiraODC = 0;

        int grupo1 = 0;
        int grupo2 = 0;
        int grupo3 = 0;
        int grupo4 = 0;

        int cantNinos = 0;
        int cantNinas = 0;

        char resp = 'S';
        
        while (resp == 'S') {
            totalHuerfanos++;
            System.out.println("\nRegistro de nino #" + totalHuerfanos + ":");
            System.out.print("Sexo (M/F): ");
            char sexo = System.console().readLine().toUpperCase().charAt(0);
            System.out.print("Edad (en anos cumplidos, 0 si menor de 1 ano): ");
            int edad = Integer.parseInt(System.console().readLine());
            System.out.print("Nombre del orfanatorio: ");
            String orfanatorio = System.console().readLine();
            System.out.print("Estado de la Republica (ej. Tachira, Distrito_Capital, Miranda, etc.): ");
            String estado = System.console().readLine();

            if (sexo == 'M') {
                cantNinos++;
            } else {
                cantNinas++;
            }

            if (estado.equalsIgnoreCase("Tachira") || estado.equalsIgnoreCase("Distrito_Capital") || estado.equalsIgnoreCase("DistritoCapital") || estado.equalsIgnoreCase("DC")) {
                huerfanosTachiraODC++;
            }

            if (edad < 1) {
                grupo1++;
            } else if (edad >= 1 && edad <= 3) {
                grupo2++;
            } else if (edad >= 4 && edad <= 6) {
                grupo3++;
            } else if (edad > 6) {
                grupo4++;
            }

            System.out.print("Desea registrar otro nino? (S/N): ");
            resp = System.console().readLine().toUpperCase().charAt(0);
        }

        System.out.println("\n--- ESTADISTICAS UNICEF ---");
        if (totalHuerfanos > 0) {
            double porcTachiraDC = ((double) huerfanosTachiraODC / totalHuerfanos) * 100.0;
            System.out.printf("a. Porcentaje de huerfanos de Tachira y Distrito Capital: %.2f%%%n", porcTachiraDC);
        }

        System.out.println("b. Cantidad de huerfanos por grupos de edad:");
        System.out.println("   Grupo 1 (menores de 1 ano): " + grupo1);
        System.out.println("   Grupo 2 (1 a 3 anos): " + grupo2);
        System.out.println("   Grupo 3 (4 a 6 anos): " + grupo3);
        System.out.println("   Grupo 4 (mayores de 6 anos): " + grupo4);

        if (totalHuerfanos > 0) {
            double porcNinos = ((double) cantNinos / totalHuerfanos) * 100.0;
            double porcNinas = ((double) cantNinas / totalHuerfanos) * 100.0;
            System.out.printf("c. Ninos (varones): %d (%.2f%%)%n", cantNinos, porcNinos);
            System.out.printf("   Ninas (hembras): %d (%.2f%%)%n", cantNinas, porcNinas);
        }
    }
}
