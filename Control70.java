public class Control70 {
    public static void main(String[] args) {
        int diasProporcionados = 0;
        int totalLecturasIngresadas = 0;
        int erroresIngresados = 0;

        double sumaMaximas = 0;
        double sumaMinimas = 0;
        int diasValidos = 0;

        double tMax = 0;
        double tMin = 0;

        System.out.println("Ingrese temperaturas diarias (Max y Min). Fin con 0 0:");
        
        while (!(tMax == 0 && tMin == 0)) {
            System.out.print("Temp Max: ");
            tMax = Double.parseDouble(System.console().readLine());
            System.out.print("Temp Min: ");
            tMin = Double.parseDouble(System.console().readLine());

            if (!(tMax == 0 && tMin == 0)) {
                diasProporcionados++;
                totalLecturasIngresadas += 2;

                int errorDia = 0;
                if (tMax < 14.0 || tMax > 30.0) {
                    erroresIngresados++;
                    errorDia = 1;
                }
                if (tMin < 14.0 || tMin > 30.0) {
                    erroresIngresados++;
                    errorDia = 1;
                }

                if (errorDia == 0) {
                    sumaMaximas += tMax;
                    sumaMinimas += tMin;
                    diasValidos++;
                }
            }
        }

        System.out.println("\n--- RESULTADOS ESTACION CLIMATICA ---");
        System.out.println("g. Numero de dias proporcionados: " + diasProporcionados);
        if (diasValidos > 0) {
            System.out.printf("h. Media maxima: %.2f C, Media minima: %.2f C%n", (sumaMaximas / diasValidos), (sumaMinimas / diasValidos));
        } else {
            System.out.println("h. No hubo dias dentro del rango normal (14 a 30 C).");
        }
        System.out.println("i. Numero de errores ingresados (temperaturas fuera de rango): " + erroresIngresados);
        if (totalLecturasIngresadas > 0) {
            double porcErrores = ((double) erroresIngresados / totalLecturasIngresadas) * 100.0;
            System.out.printf("j. Porcentaje que representan los errores: %.2f%%%n", porcErrores);
        }
    }
}
