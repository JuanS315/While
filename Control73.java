public class Control73 {
    public static void main(String[] args) {
        System.out.print("Ingrese fecha de corte para el reporte (dd/mm/aaaa): ");
        String fechaCorte = System.console().readLine();

        System.out.print("Ingrese cantidad de Estados a procesar: ");
        int cantEstados = Integer.parseInt(System.console().readLine());
        int e = 1;

        double sumaMaximosAgenciasNacional = 0;
        int totalAgenciasNacional = 0;

        if (cantEstados > 0) {
            while (e <= cantEstados) {
                System.out.println("\n==========================================");
                System.out.print("Codigo del Estado #" + e + ": ");
                String codEstado = System.console().readLine();
                System.out.print("Cantidad de agencias en el Estado " + codEstado + ": ");
                int cantAgencias = Integer.parseInt(System.console().readLine());

                double totalAdeudadoEstado = 0;
                double maxDeudaAgenciaEstado = -1;
                String codAgenciaMaxEstado = "";
                double minDeudaAgenciaEstado = Double.MAX_VALUE;
                String codAgenciaMinEstado = "";

                int a = 1;
                if (cantAgencias > 0) {
                    while (a <= cantAgencias) {
                        System.out.println("\n------------------------------------------");
                        System.out.print("Codigo de la Agencia #" + a + ": ");
                        String codAgencia = System.console().readLine();
                        System.out.print("Cantidad de clientes con pagares en agencia " + codAgencia + ": ");
                        int cantClientes = Integer.parseInt(System.console().readLine());

                        double totalAdeudadoAgencia = 0;
                        double maxDeudaClienteAgencia = -1;
                        String codClienteMaxAgencia = "";

                        int c = 1;
                        if (cantClientes > 0) {
                            while (c <= cantClientes) {
                                System.out.println("\n--- RECIBO DE PAGO PENDIENTE (Fecha: " + fechaCorte + ") ---");
                                System.out.print("Codigo client: ");
                                String codCliente = System.console().readLine();
                                System.out.print("Nombre client: ");
                                String nomCliente = System.console().readLine();
                                System.out.print("Direccion client: ");
                                String dirCliente = System.console().readLine();
                                System.out.print("Cantidad de pagares pendientes: ");
                                int cantPagares = Integer.parseInt(System.console().readLine());

                                System.out.println("Cliente: " + codCliente + " - " + nomCliente);
                                System.out.println("Direccion: " + dirCliente);
                                System.out.println("Estado: " + codEstado + " | Agencia: " + codAgencia);
                                System.out.println("Detalle de Pagares:");

                                double totalPendienteCliente = 0;
                                int p = 1;
                                if (cantPagares > 0) {
                                    while (p <= cantPagares) {
                                        System.out.print("  Pagare #" + p + " - Numero: ");
                                        String numPagare = System.console().readLine();
                                        System.out.print("  Pagare #" + p + " - Vencimiento (dd/mm/aaaa): ");
                                        String fecVenc = System.console().readLine();
                                        System.out.print("  Pagare #" + p + " - Monto: ");
                                        double montoPag = Double.parseDouble(System.console().readLine());

                                        totalPendienteCliente += montoPag;
                                        System.out.printf("  -> Pagare No: %s | Vence: %s | Monto: %.2f Bs.%n", numPagare, fecVenc, montoPag);
                                        p++;
                                    }
                                }

                                System.out.println("Total pagares pendientes: " + cantPagares);
                                System.out.printf("Monto total pendiente cliente: %.2f Bs.%n", totalPendienteCliente);

                                totalAdeudadoAgencia += totalPendienteCliente;
                                if (c == 1 || totalPendienteCliente > maxDeudaClienteAgencia) {
                                    maxDeudaClienteAgencia = totalPendienteCliente;
                                    codClienteMaxAgencia = codCliente;
                                }

                                c++;
                            }
                        }

                        System.out.println("\n--- RESUMEN AGENCIA " + codAgencia + " ---");
                        System.out.println("Estado: " + codEstado);
                        System.out.println("Clientes con pagares pendientes: " + cantClientes);
                        System.out.printf("Monto total adeudado agencia: %.2f Bs.%n", totalAdeudadoAgencia);
                        System.out.println("Codigo cliente con mayor deuda: " + codClienteMaxAgencia);

                        totalAdeudadoEstado += totalAdeudadoAgencia;
                        totalAgenciasNacional++;
                        sumaMaximosAgenciasNacional += maxDeudaClienteAgencia;

                        if (a == 1 || totalAdeudadoAgencia > maxDeudaAgenciaEstado) {
                            maxDeudaAgenciaEstado = totalAdeudadoAgencia;
                            codAgenciaMaxEstado = codAgencia;
                        }
                        if (a == 1 || totalAdeudadoAgencia < minDeudaAgenciaEstado) {
                            minDeudaAgenciaEstado = totalAdeudadoAgencia;
                            codAgenciaMinEstado = codAgencia;
                        }

                        a++;
                    }
                }

                System.out.println("\n=== RESUMEN ESTADO " + codEstado + " ===");
                System.out.printf("Monto total adeudado en estado: %.2f Bs.%n", totalAdeudadoEstado);
                System.out.println("Agencia con menor monto adeudado: " + codAgenciaMinEstado);
                System.out.println("Agencia con mayor monto adeudado: " + codAgenciaMaxEstado);

                e++;
            }
        }

        if (totalAgenciasNacional > 0) {
            double promMaximos = sumaMaximosAgenciasNacional / totalAgenciasNacional;
            System.out.printf("\n*** MONTO PROMEDIO ADEUDADO EN RAZON DE MONTOS MAXIMOS POR AGENCIA: %.2f Bs. ***%n", promMaximos);
        }
    }
}
