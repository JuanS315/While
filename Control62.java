public class Control62 {
    public static void main(String[] args) {
        int totalEmpresas = 0;
        int cantAgricola = 0;
        int cantIndustrial = 0;
        int cantMinera = 0;
        int cantPesquera = 0;
        int cantOtra = 0;

        int mineraSur = 0;

        int trabAgricola = 0;
        int trabIndustrial = 0;
        int trabMinera = 0;
        int trabPesquera = 0;
        int trabOtra = 0;

        int indNorte = 0;
        int indSur = 0;
        int indEste = 0;
        int indOeste = 0;

        char cont = 'S';
        
        while (cont == 'S') {
            totalEmpresas++;
            System.out.println("\nEmpresa #" + totalEmpresas + ":");
            System.out.print("Actividad (1=Agricola, 2=Industrial, 3=Minera, 4=Pesquera, 5=Otra): ");
            int act = Integer.parseInt(System.console().readLine());
            System.out.print("Localizacion (1=Norte, 2=Sur, 3=Este, 4=Oeste): ");
            int loc = Integer.parseInt(System.console().readLine());
            System.out.print("Numero de trabajadores: ");
            int trab = Integer.parseInt(System.console().readLine());

            if (act == 1) {
                cantAgricola++;
                trabAgricola += trab;
            } else if (act == 2) {
                cantIndustrial++;
                trabIndustrial += trab;
                if (loc == 1) {
                    indNorte++;
                } else if (loc == 2) {
                    indSur++;
                } else if (loc == 3) {
                    indEste++;
                } else if (loc == 4) {
                    indOeste++;
                }
            } else if (act == 3) {
                cantMinera++;
                trabMinera += trab;
                if (loc == 2) {
                    mineraSur++;
                }
            } else if (act == 4) {
                cantPesquera++;
                trabPesquera += trab;
            } else if (act == 5) {
                cantOtra++;
                trabOtra += trab;
            }

            System.out.print("Desea ingresar otra empresa? (S/N): ");
            cont = System.console().readLine().toUpperCase().charAt(0);
        }

        System.out.println("\n--- ESTADISTICAS DE EMPRESAS ---");
        if (totalEmpresas > 0) {
            double porcAgricola = ((double) cantAgricola / totalEmpresas) * 100.0;
            System.out.printf("i. Porcentaje de empresas agricolas: %.2f%%%n", porcAgricola);
        }

        if (cantMinera > 0) {
            double porcMineraSur = ((double) mineraSur / cantMinera) * 100.0;
            System.out.printf("ii. Porcentaje de mineras del Sur respecto a total mineras: %.2f%%%n", porcMineraSur);
        } else {
            System.out.println("ii. No se registraron empresas mineras.");
        }

        System.out.println("iii. Promedio de trabajadores por actividad:");
        if (cantAgricola > 0) {
            System.out.printf("   Agricola: %.2f%n", ((double) trabAgricola / cantAgricola));
        } else {
            System.out.println("   Agricola: 0");
        }
        if (cantIndustrial > 0) {
            System.out.printf("   Industrial: %.2f%n", ((double) trabIndustrial / cantIndustrial));
        } else {
            System.out.println("   Industrial: 0");
        }
        if (cantMinera > 0) {
            System.out.printf("   Minera: %.2f%n", ((double) trabMinera / cantMinera));
        } else {
            System.out.println("   Minera: 0");
        }
        if (cantPesquera > 0) {
            System.out.printf("   Pesquera: %.2f%n", ((double) trabPesquera / cantPesquera));
        } else {
            System.out.println("   Pesquera: 0");
        }
        if (cantOtra > 0) {
            System.out.printf("   Otra: %.2f%n", ((double) trabOtra / cantOtra));
        } else {
            System.out.println("   Otra: 0");
        }

        System.out.print("iv. Localizacion con mayor numero de empresas industriales: ");
        int maxInd = indNorte;
        String locMax = "Norte";
        if (indSur > maxInd) {
            maxInd = indSur;
            locMax = "Sur";
        }
        if (indEste > maxInd) {
            maxInd = indEste;
            locMax = "Este";
        }
        if (indOeste > maxInd) {
            maxInd = indOeste;
            locMax = "Oeste";
        }
        if (cantIndustrial == 0) {
            System.out.println("Ninguna empresa industrial registrada.");
        } else {
            System.out.println(locMax + " (con " + maxInd + " empresas)");
        }
    }
}
