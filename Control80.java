public class Control80 {
    public static void main(String[] args) {
        System.out.print("Ingrese cantidad de Estados a censar: ");
        int cantEstados = Integer.parseInt(System.console().readLine());
        int e = 1;

        double maxPorcProfDesempleadosEstado = -1;
        String codEstadoMaxProfDesemp = "";

        if (cantEstados > 0) {
            while (e <= cantEstados) {
                System.out.println("\n==========================================");
                System.out.print("Codigo del Estado (2 digitos): ");
                String codEstado = System.console().readLine();
                System.out.print("Cantidad de ciudades en el Estado: ");
                int cantCiudades = Integer.parseInt(System.console().readLine());

                int totalProfesionalesEstado = 0;
                int totalProfDesempleadosEstado = 0;

                int c = 1;
                if (cantCiudades > 0) {
                    while (c <= cantCiudades) {
                        System.out.println("\n------------------------------------------");
                        System.out.print("Codigo de la ciudad (4 digitos): ");
                        String codCiudad = System.console().readLine();
                        System.out.print("Cantidad de municipios en la ciudad: ");
                        int cantMunicipios = Integer.parseInt(System.console().readLine());

                        int totalPersonasCiudad = 0;
                        int totalCondicionCiudad = 0;

                        int m = 1;
                        if (cantMunicipios > 0) {
                            while (m <= cantMunicipios) {
                                System.out.println("\n--- Municipio #" + m + " ---");
                                System.out.print("Codigo del municipio (6 digitos): ");
                                String codMun = System.console().readLine();
                                System.out.print("Cantidad de personas a registrar en municipio: ");
                                int cantPersonas = Integer.parseInt(System.console().readLine());

                                int personasCondicionMun = 0;
                                int p = 1;
                                if (cantPersonas > 0) {
                                    while (p <= cantPersonas) {
                                        System.out.print("  Persona #" + p + " - Edad (>18): ");
                                        int edad = Integer.parseInt(System.console().readLine());
                                        System.out.print("  Persona #" + p + " - Educacion (N, B, S, P): ");
                                        char edu = System.console().readLine().toUpperCase().charAt(0);
                                        System.out.print("  Persona #" + p + " - Situacion (D: Desempleado, E: Empleado): ");
                                        char sit = System.console().readLine().toUpperCase().charAt(0);

                                        if (sit == 'D' && edu == 'N' && edad > 25) {
                                            personasCondicionMun++;
                                        }

                                        if (edu == 'P') {
                                            totalProfesionalesEstado++;
                                            if (sit == 'D') {
                                                totalProfDesempleadosEstado++;
                                            }
                                        }

                                        p++;
                                    }
                                }

                                System.out.println("Municipio " + codMun + ": " + personasCondicionMun + " personas desempleadas, sin educacion y > 25 anos.");
                                totalCondicionCiudad += personasCondicionMun;
                                totalPersonasCiudad += cantPersonas;

                                m++;
                            }
                        }

                        if (totalPersonasCiudad > 0) {
                            double porcCondicionCiudad = ((double) totalCondicionCiudad / totalPersonasCiudad) * 100.0;
                            if (porcCondicionCiudad > 50.0) {
                                System.out.printf(">>> ALERTA CIUDAD %s: Mas del 50%% de personas con la condicion especial (%.2f%%)%n", codCiudad, porcCondicionCiudad);
                            }
                        }

                        c++;
                    }
                }

                double porcProfDesempEstado = 0;
                if (totalProfesionalesEstado > 0) {
                    porcProfDesempEstado = ((double) totalProfDesempleadosEstado / totalProfesionalesEstado) * 100.0;
                }

                if (e == 1 || porcProfDesempEstado > maxPorcProfDesempleadosEstado) {
                    maxPorcProfDesempleadosEstado = porcProfDesempEstado;
                    codEstadoMaxProfDesemp = codEstado;
                }

                e++;
            }
        }

        System.out.println("\n==========================================");
        System.out.printf("Estado con mayor porcentaje de profesionales desempleados: %s (%.2f%%)%n", codEstadoMaxProfDesemp, maxPorcProfDesempleadosEstado);
    }
}
