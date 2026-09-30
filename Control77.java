public class Control77 {
    public static void main(String[] args) {
        System.out.print("Ingrese la poblacion total del Pais: ");
        double poblacionTotalPais = Double.parseDouble(System.console().readLine());

        int totalEstados = 5;
        int e = 1;

        double maxPoblacionEstado = -1;
        String nomEstadoMayor = "";
        double minPoblacionEstado = Double.MAX_VALUE;
        String nomEstadoMenor = "";

        double sumaPoblacion5Estados = 0;
        
        while (e <= totalEstados) {
            System.out.println("\n--- Estado #" + e + " de 5 ---");
            System.out.print("Nombre del Estado: ");
            String nomEstado = System.console().readLine();
            System.out.print("Cantidad de municipios (M): ");
            int m = Integer.parseInt(System.console().readLine());

            double poblacionEstado = 0;
            int mun = 1;
            if (m > 0) {
                while (mun <= m) {
                    System.out.print("Poblacion del municipio #" + mun + ": ");
                    double pobMun = Double.parseDouble(System.console().readLine());
                    poblacionEstado += pobMun;
                    mun++;
                }
            }

            System.out.printf("Poblacion total de %s: %.0f habitantes%n", nomEstado, poblacionEstado);
            sumaPoblacion5Estados += poblacionEstado;

            if (e == 1 || poblacionEstado > maxPoblacionEstado) {
                maxPoblacionEstado = poblacionEstado;
                nomEstadoMayor = nomEstado;
            }
            if (e == 1 || poblacionEstado < minPoblacionEstado) {
                minPoblacionEstado = poblacionEstado;
                nomEstadoMenor = nomEstado;
            }

            e++;
        }

        System.out.println("\n==========================================");
        System.out.println("--- ESTADISTICAS POBLACIONALES ---");
        System.out.printf("a. Estado con mayor poblacion: %s con %.0f habitantes%n", nomEstadoMayor, maxPoblacionEstado);
        System.out.printf("b. Estado con menor poblacion: %s con %.0f habitantes%n", nomEstadoMenor, minPoblacionEstado);

        if (poblacionTotalPais > 0) {
            double porc5Estados = (sumaPoblacion5Estados / poblacionTotalPais) * 100.0;
            System.out.printf("c. Porcentaje de los 5 estados respecto al pais: %.2f%%%n", porc5Estados);
        }
        System.out.printf("d. Promedio de habitantes por Estado: %.2f habitantes%n", (sumaPoblacion5Estados / totalEstados));
    }
}
