public class Control66 {
    public static void main(String[] args) {
        int totalPasajerosGeneral = 0;
        int pasajerosSinPagoGeneral = 0;
        char respVuelo = 'S';
        
        while (respVuelo == 'S') {
            System.out.print("\nIngrese Numero de Vuelo: ");
            String numVuelo = System.console().readLine();
            System.out.print("Ingrese cantidad de pasajeros para el vuelo " + numVuelo + ": ");
            int cantPasajerosVuelo = Integer.parseInt(System.console().readLine());

            double totalMontoVuelo = 0;
            double maxPesoVuelo = -1;
            String pasajeroMaxPesoVuelo = "";
            String codigoAbordoMaxVuelo = "";

            double minPesoVuelo = 999999;
            String pasajeroMinPesoVuelo = "";
            String codigoAbordoMinVuelo = "";

            int p = 1;
            if (cantPasajerosVuelo > 0) {
                while (p <= cantPasajerosVuelo) {
                    System.out.println("\n--- Pasajero #" + p + " del vuelo " + numVuelo + " ---");
                    System.out.print("Codigo de abordo: ");
                    String codAbordo = System.console().readLine();
                    System.out.print("Nombre del pasajero: ");
                    String nomPasajero = System.console().readLine();
                    System.out.print("Cantidad de maletas: ");
                    int cantMaletas = Integer.parseInt(System.console().readLine());

                    double pesoTotalPasajero = 0;
                    double maxPesoMaleta = -1;
                    String codMaletaMayor = "";

                    int m = 1;
                    if (cantMaletas > 0) {
                        while (m <= cantMaletas) {
                            System.out.print("Codigo maleta #" + m + ": ");
                            String codMaleta = System.console().readLine();
                            System.out.print("Peso de la maleta (kg): ");
                            double pesoM = Double.parseDouble(System.console().readLine());

                            pesoTotalPasajero += pesoM;
                            if (pesoM > maxPesoMaleta) {
                                maxPesoMaleta = pesoM;
                                codMaletaMayor = codMaleta;
                            }
                            m++;
                        }
                    }

                    double tarifaPorKg = 0;
                    if (pesoTotalPasajero <= 3.0) {
                        tarifaPorKg = 0;
                    } else if (pesoTotalPasajero <= 6.0) {
                        tarifaPorKg = 600;
                    } else if (pesoTotalPasajero <= 9.0) {
                        tarifaPorKg = 1200;
                    } else if (pesoTotalPasajero <= 12.0) {
                        tarifaPorKg = 1500;
                    } else if (pesoTotalPasajero <= 15.0) {
                        tarifaPorKg = 2000;
                    } else {
                        tarifaPorKg = 2500;
                    }

                    double montoPagarPasajero = pesoTotalPasajero * tarifaPorKg;
                    totalMontoVuelo += montoPagarPasajero;
                    totalPasajerosGeneral++;
                    if (montoPagarPasajero == 0) {
                        pasajerosSinPagoGeneral++;
                    }

                    System.out.println("\ni. Info Pasajero: Vuelo " + numVuelo + ", Cod Abordo: " + codAbordo + ", Nombre: " + nomPasajero + ", Peso Total: " + pesoTotalPasajero + " kg, Monto: " + montoPagarPasajero + " Bs.");
                    System.out.println("ii. Maleta con mayor peso de " + nomPasajero + ": Codigo " + codMaletaMayor + " con " + maxPesoMaleta + " kg.");

                    if (pesoTotalPasajero > maxPesoVuelo) {
                        maxPesoVuelo = pesoTotalPasajero;
                        pasajeroMaxPesoVuelo = nomPasajero;
                        codigoAbordoMaxVuelo = codAbordo;
                    }

                    if (pesoTotalPasajero < minPesoVuelo) {
                        minPesoVuelo = pesoTotalPasajero;
                        pasajeroMinPesoVuelo = nomPasajero;
                        codigoAbordoMinVuelo = codAbordo;
                    }

                    p++;
                }
            }

            System.out.println("\n--- RESUMEN VUELO " + numVuelo + " ---");
            System.out.println("iii. Pasajero con mayor peso: " + pasajeroMaxPesoVuelo + " (Cod: " + codigoAbordoMaxVuelo + ", Peso: " + maxPesoVuelo + " kg)");
            System.out.println("     Pasajero con menor peso: " + pasajeroMinPesoVuelo + " (Cod: " + codigoAbordoMinVuelo + ", Peso: " + minPesoVuelo + " kg)");
            System.out.printf("iv. Monto total cancelado por equipaje en el vuelo %s: %.2f Bs.%n", numVuelo, totalMontoVuelo);

            System.out.print("\nDesea procesar otro vuelo? (S/N): ");
            respVuelo = System.console().readLine().toUpperCase().charAt(0);
        }

        if (totalPasajerosGeneral > 0) {
            double porcSinPago = ((double) pasajerosSinPagoGeneral / totalPasajerosGeneral) * 100.0;
            System.out.printf("\nv. Porcentaje general de pasajeros que no pagaron por equipaje: %.2f%%%n", porcSinPago);
        }
    }
}
