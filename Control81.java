public class Control81 {
    public static void main(String[] args) {
        System.out.print("Ingrese cantidad de Estados a procesar: ");
        int cantEstados = Integer.parseInt(System.console().readLine());
        int e = 1;

        if (cantEstados > 0) {
            while (e <= cantEstados) {
                System.out.println("\n==========================================");
                System.out.print("Codigo del Estado (2 digitos): ");
                String codEstado = System.console().readLine();
                System.out.print("Nombre del Estado: ");
                String nomEstado = System.console().readLine();
                System.out.print("Cantidad de ciudades en " + nomEstado + ": ");
                int cantCiudades = Integer.parseInt(System.console().readLine());

                double montoNetoTotalEstado = 0;
                int ciudadesNoAlcanzaronMeta = 0;
                int ciudades40a60PorcEncima = 0;

                int c = 1;
                
                if (cantCiudades > 0) {
                    while (c <= cantCiudades) {
                        System.out.println("\n------------------------------------------");
                        System.out.print("Codigo de la ciudad (3 digitos): ");
                        String codCiudad = System.console().readLine();
                        System.out.print("Nombre de la ciudad: ");
                        String nomCiudad = System.console().readLine();
                        System.out.print("Cantidad esperada de unidades de venta: ");
                        int unidadesEsperadas = Integer.parseInt(System.console().readLine());
                        System.out.print("Cantidad de canales de comercializacion en la ciudad: ");
                        int cantCanales = Integer.parseInt(System.console().readLine());

                        int totalUnidadesCiudad = 0;
                        double totalBrutoCiudad = 0;
                        double comisionTiendaCiudad = 0;
                        double comisionCalleCiudad = 0;

                        double maxVentaNetaCanal = -1;
                        String codCanalMaxVenta = "";

                        int minUnidadesVendedor = Integer.MAX_VALUE;
                        String codVendedorMinUnidades = "";

                        int k = 1;
                        
                        if (cantCanales > 0) {
                            while (k <= cantCanales) {
                                System.out.println("\n--- Canal de Comercializacion #" + k + " ---");
                                System.out.print("Codigo del canal (4 digitos): ");
                                String codCanal = System.console().readLine();
                                System.out.print("Cantidad de vendedores en este canal: ");
                                int cantVendedores = Integer.parseInt(System.console().readLine());

                                double ventaNetaCanal = 0;
                                int v = 1;
                                
                                if (cantVendedores > 0) {
                                    while (v <= cantVendedores) {
                                        System.out.print("  Codigo vendedor #" + v + " (5 digitos, inicia con 11=tienda o 12=calle): ");
                                        String codVendedor = System.console().readLine();
                                        System.out.print("  Unidades vendidas: ");
                                        int unidVendidas = Integer.parseInt(System.console().readLine());
                                        System.out.print("  Monto total vendido: ");
                                        double montoVendido = Double.parseDouble(System.console().readLine());

                                        totalUnidadesCiudad += unidVendidas;
                                        totalBrutoCiudad += montoVendido;

                                        double comisionVendedor = 0;
                                        
                                        if (codVendedor.startsWith("11")) {
                                            comisionVendedor = montoVendido * 0.10;
                                            comisionTiendaCiudad += comisionVendedor;
                                        } else if (codVendedor.startsWith("12")) {
                                            comisionVendedor = montoVendido * 0.15;
                                            comisionCalleCiudad += comisionVendedor;
                                        }

                                        ventaNetaCanal += (montoVendido - comisionVendedor);

                                        if (unidVendidas < minUnidadesVendedor) {
                                            minUnidadesVendedor = unidVendidas;
                                            codVendedorMinUnidades = codVendedor;
                                        }

                                        v++;
                                    }
                                }

                                if (k == 1 || ventaNetaCanal > maxVentaNetaCanal) {
                                    maxVentaNetaCanal = ventaNetaCanal;
                                    codCanalMaxVenta = codCanal;
                                }

                                k++;
                            }
                        }

                        double totalNetoCiudad = totalBrutoCiudad - comisionTiendaCiudad - comisionCalleCiudad;
                        montoNetoTotalEstado += totalNetoCiudad;

                        if (totalUnidadesCiudad < unidadesEsperadas) {
                            ciudadesNoAlcanzaronMeta++;
                        } else {
                            double porcEncima = ((double) (totalUnidadesCiudad - unidadesEsperadas) / unidadesEsperadas) * 100.0;
                            if (porcEncima >= 40.0 && porcEncima <= 60.0) {
                                ciudades40a60PorcEncima++;
                            }
                        }

                        System.out.println("\n*** REPORTE CIUDAD " + codCiudad + " (" + nomCiudad + ") ***");
                        System.out.println("Total unidades vendidas: " + totalUnidadesCiudad);
                        System.out.printf("Monto total bruto: %.2f Bs.%n", totalBrutoCiudad);
                        System.out.printf("Comision vendedores tienda: %.2f Bs.%n", comisionTiendaCiudad);
                        System.out.printf("Comision vendedores calle: %.2f Bs.%n", comisionCalleCiudad);
                        System.out.println("Canal con mayor venta neta: Codigo " + codCanalMaxVenta + " (" + maxVentaNetaCanal + " Bs.)");
                        System.out.println("Vendedor con menor unidades vendidas: Codigo " + codVendedorMinUnidades + " (" + minUnidadesVendedor + " unidades)");

                        c++;
                    }
                }

                double porcCiudadesNoMeta = (cantCiudades > 0) ? (((double) ciudadesNoAlcanzaronMeta / cantCiudades) * 100.0) : 0;

                System.out.println("\n==========================================");
                System.out.println("=== REPORTE ESTADO " + codEstado + " (" + nomEstado + ") ===");
                System.out.printf("Monto neto vendido en el Estado: %.2f Bs.%n", montoNetoTotalEstado);
                System.out.printf("Porcentaje de ciudades que no alcanzaron la meta: %.2f%%%n", porcCiudadesNoMeta);
                System.out.println("Cantidad de ciudades con 40% a 60% por encima de la meta: " + ciudades40a60PorcEncima);

                e++;
            }
        }
    }
}
