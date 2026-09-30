public class Control72 {
    public static void main(String[] args) {
        double G = 6.67259e-11;
        double M_tierra = 5.97e24;

        int totalSatelites = 0;
        double sumaFuerza = 0;
        double sumaMasa = 0;

        double maxFuerza = -1;
        double minFuerza = Double.MAX_VALUE;
        String satMaxFuerza = "";
        String satMinFuerza = "";

        double maxMasa = -1;
        String satMaxMasa = "";

        double minAltura = Double.MAX_VALUE;
        double maxAltura = -1;
        String satMinAltura = "";
        String satMaxAltura = "";

        System.out.print("Ingrese el numero de satelites a procesar (ej. 4 para los datos muestra): ");
        int nSatelites = Integer.parseInt(System.console().readLine());
        int i = 1;

        if (nSatelites > 0) {
            
            while (i <= nSatelites) {
                System.out.println("\n--- Satelite #" + i + " ---");
                System.out.print("Nombre del satelite: ");
                String nombre = System.console().readLine();
                System.out.print("Pais: ");
                String pais = System.console().readLine();
                System.out.print("Masa (Kg): ");
                double masa = Double.parseDouble(System.console().readLine());
                System.out.print("Altura/Distancia (Mts): ");
                double r = Double.parseDouble(System.console().readLine());

                double fuerza = (G * masa * M_tierra) / (r * r);

                totalSatelites++;
                sumaFuerza += fuerza;
                sumaMasa += masa;

                if (i == 1 || fuerza > maxFuerza) {
                    maxFuerza = fuerza;
                    satMaxFuerza = nombre;
                }
                if (i == 1 || fuerza < minFuerza) {
                    minFuerza = fuerza;
                    satMinFuerza = nombre;
                }

                if (i == 1 || masa > maxMasa) {
                    maxMasa = masa;
                    satMaxMasa = nombre;
                }

                if (i == 1 || r < minAltura) {
                    minAltura = r;
                    satMinAltura = nombre;
                }
                if (i == 1 || r > maxAltura) {
                    maxAltura = r;
                    satMaxAltura = nombre;
                }

                System.out.printf("Fuerza calculada para %s: %.4f N%n", nombre, fuerza);
                i++;
            }
        }

        System.out.println("\n--- INFORME FINAL NASA ---");
        System.out.printf("a) Mayor fuerza de atraccion: %.4f N (%s)%n", maxFuerza, satMaxFuerza);
        System.out.printf("   Menor fuerza de atraccion: %.4f N (%s)%n", minFuerza, satMinFuerza);
        if (totalSatelites > 0) {
            System.out.printf("b) Fuerza de atraccion promedio: %.4f N%n", (sumaFuerza / totalSatelites));
        }
        System.out.printf("c) Mayor masa estudiada: %.2f Kg (%s)%n", maxMasa, satMaxMasa);
        if (totalSatelites > 0) {
            System.out.printf("d) Masa promedio: %.2f Kg%n", (sumaMasa / totalSatelites));
        }
        System.out.printf("e) Menor altura: %.2f Mts (%s)%n", minAltura, satMinAltura);
        System.out.printf("   Mayor altura: %.2f Mts (%s)%n", maxAltura, satMaxAltura);
    }
}
