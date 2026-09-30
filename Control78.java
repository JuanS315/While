public class Control78 {
    public static void main(String[] args) {
        double pvp1 = 100.0;
        double pvp2 = 200.0;
        double pvp3 = 300.0;

        System.out.print("Ingrese cantidad de sucursales a procesar: ");
        int cantSucursales = Integer.parseInt(System.console().readLine());
        int s = 1;

        int sucursalesCumplieron = 0;

        if (cantSucursales > 0) {
            while (s <= cantSucursales) {
                System.out.println("\n==========================================");
                System.out.print("Codigo de la sucursal (2 digitos): ");
                int codSucursal = Integer.parseInt(System.console().readLine());
                System.out.print("Descripcion de la sucursal: ");
                String descSucursal = System.console().readLine();
                System.out.print("Monto de venta esperado (Bs.): ");
                double ventaEsperada = Double.parseDouble(System.console().readLine());
                System.out.print("Cantidad de puntos de venta de la sucursal: ");
                int cantPuntos = Integer.parseInt(System.console().readLine());

                double totalVendidoSucursal = 0;
                double maxComisionPunto = -1;
                int codPuntoMaxComision = 0;

                int p = 1;
                if (cantPuntos > 0) {
                    while (p <= cantPuntos) {
                        System.out.println("\n--- Punto de Venta #" + p + " ---");
                        System.out.print("Codigo de punto de venta (4 digitos): ");
                        int codPunto = Integer.parseInt(System.console().readLine());

                        System.out.print("Unidades vendidas Producto 1: ");
                        int u1 = Integer.parseInt(System.console().readLine());
                        System.out.print("Unidades vendidas Producto 2: ");
                        int u2 = Integer.parseInt(System.console().readLine());
                        System.out.print("Unidades vendidas Producto 3: ");
                        int u3 = Integer.parseInt(System.console().readLine());

                        int totalUnidadesPunto = u1 + u2 + u3;
                        double montoBrutoPunto = (u1 * pvp1) + (u2 * pvp2) + (u3 * pvp3);
                        double comisionVendedores = montoBrutoPunto * 0.10;
                        double montoNetoPunto = montoBrutoPunto - comisionVendedores;

                        int codProductoMenosVendido = 1;
                        int minUnidades = u1;
                        if (u2 < minUnidades) {
                            minUnidades = u2;
                            codProductoMenosVendido = 2;
                        }
                        if (u3 < minUnidades) {
                            minUnidades = u3;
                            codProductoMenosVendido = 3;
                        }

                        System.out.println("Resultados Punto de Venta " + codPunto + ":");
                        System.out.println("  Total unidades vendidas: " + totalUnidadesPunto);
                        System.out.printf("  Monto neto de la venta: %.2f Bs.%n", montoNetoPunto);
                        System.out.printf("  Monto comision vendedores: %.2f Bs.%n", comisionVendedores);
                        System.out.println("  Codigo producto menor unidades vendidas: " + codProductoMenosVendido + " (" + minUnidades + " unidades)");

                        totalVendidoSucursal += montoBrutoPunto;

                        if (p == 1 || comisionVendedores > maxComisionPunto) {
                            maxComisionPunto = comisionVendedores;
                            codPuntoMaxComision = codPunto;
                        }

                        p++;
                    }
                }

                double porcAlcanzado = (ventaEsperada > 0) ? ((totalVendidoSucursal / ventaEsperada) * 100.0) : 0;
                if (totalVendidoSucursal >= ventaEsperada) {
                    sucursalesCumplieron++;
                }

                System.out.println("\n--- RESUMEN SUCURSAL " + codSucursal + " (" + descSucursal + ") ---");
                System.out.printf("Monto total vendido: %.2f Bs.%n", totalVendidoSucursal);
                System.out.printf("Porcentaje alcanzado vs esperado: %.2f%%%n", porcAlcanzado);
                System.out.printf("Punto de venta con mayor comision: Codigo %d con %.2f Bs.%n", codPuntoMaxComision, maxComisionPunto);

                s++;
            }
        }

        if (cantSucursales > 0) {
            double porcSucursalesMeta = ((double) sucursalesCumplieron / cantSucursales) * 100.0;
            System.out.println("\n==========================================");
            System.out.printf("Porcentaje de sucursales que alcanzaron el monto esperado: %.2f%%%n", porcSucursalesMeta);
        }
    }
}
