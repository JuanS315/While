public class Control74 {
    public static void main(String[] args) {
        System.out.print("Ingrese el limite/meta de unidades a producir por semana (X): ");
        double metaX = Double.parseDouble(System.console().readLine());
        System.out.print("Ingrese cantidad de obreros: ");
        int totalObreros = Integer.parseInt(System.console().readLine());

        int obrerosCumplieron = 0;
        double maxProduccion = -1;
        String obreroMasProdujo = "";
        double sumaProduccionTotal = 0;

        int o = 1;
        if (totalObreros > 0) {
            while (o <= totalObreros) {
                System.out.println("\n--- Obrero #" + o + " ---");
                System.out.print("Nombre: ");
                String nombre = System.console().readLine();

                double totalSemanaObrero = 0;
                int dia = 1;
                while (dia <= 6) {
                    System.out.print("Produccion dia " + dia + " (bloques): ");
                    double prodDia = Double.parseDouble(System.console().readLine());
                    totalSemanaObrero += prodDia;
                    dia++;
                }

                double porcMeta = (totalSemanaObrero / metaX) * 100.0;

                System.out.println("\nResumen Obrero:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Total producido en la semana: " + totalSemanaObrero + " bloques");
                System.out.printf("Porcentaje respecto al limite establecido: %.2f%%%n", porcMeta);

                if (totalSemanaObrero >= metaX) {
                    obrerosCumplieron++;
                }

                if (o == 1 || totalSemanaObrero > maxProduccion) {
                    maxProduccion = totalSemanaObrero;
                    obreroMasProdujo = nombre;
                }

                sumaProduccionTotal += totalSemanaObrero;
                o++;
            }
        }

        System.out.println("\n==========================================");
        System.out.println("--- RESUMEN GENERAL BLOQUERA EL MILAGRO ---");
        if (totalObreros > 0) {
            double porcCumplieron = ((double) obrerosCumplieron / totalObreros) * 100.0;
            System.out.printf("Porcentaje de obreros que alcanzaron/superaron la meta: %.2f%%%n", porcCumplieron);
            System.out.println("Obrero que mas produjo: " + obreroMasProdujo + " (" + maxProduccion + " bloques)");
            System.out.printf("Promedio de produccion por obrero en la semana: %.2f bloques%n", (sumaProduccionTotal / totalObreros));
        }
    }
}
