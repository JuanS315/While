public class Control54 {
    public static void main(String[] args) {
        int totalCuestionarios = 64;
        int totalPreguntas = 23;
        int c = 1;

        double sumaPromedios = 0;
        double maxPromedio = -1;
        int numMax = 0;
        double minPromedio = 999;
        int numMin = 0;

        int cantMenor3 = 0;
        int cantMayor4 = 0;
        int cantEntre45y5 = 0;

        System.out.print("Ingrese cantidad de cuestionarios a evaluar (64 segun enunciado): ");
        totalCuestionarios = Integer.parseInt(System.console().readLine());
        
        while (c <= totalCuestionarios) {
            System.out.println("--- Cuestionario " + c + " ---");
            double pt = 0;
            int p = 1;
            
            while (p <= totalPreguntas) {
                System.out.print("Puntaje de pregunta " + p + " (1 a 5): ");
                double puntaje = Double.parseDouble(System.console().readLine());
                if (puntaje < 1) {
                    puntaje = 1;
                } else if (puntaje > 5) {
                    puntaje = 5;
                }
                pt += puntaje;
                p++;
            }

            double prom = pt / totalPreguntas;
            sumaPromedios += prom;

            if (c == 1 || prom > maxPromedio) {
                maxPromedio = prom;
                numMax = c;
            }
            if (c == 1 || prom < minPromedio) {
                minPromedio = prom;
                numMin = c;
            }

            if (prom < 3.0) {
                cantMenor3++;
            }
            if (prom > 4.0) {
                cantMayor4++;
            }
            if (prom >= 4.5 && prom <= 5.0) {
                cantEntre45y5++;
            }

            c++;
        }

        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.printf("a. Media o promedio general de todos los cuestionarios: %.2f%n", (sumaPromedios / totalCuestionarios));
        System.out.printf("b. Promedio mas alto: %.2f (Instrumento #%d)%n", maxPromedio, numMax);
        System.out.printf("c. Promedio mas bajo: %.2f (Instrumento #%d)%n", minPromedio, numMin);

        if (cantMayor4 > 0) {
            double porcMenor3 = ((double) cantMenor3 / cantMayor4) * 100.0;
            System.out.printf("d. Porcentaje promedio < 3 respecto a > 4: %.2f%%%n", porcMenor3);
        } else {
            System.out.println("d. No hubo cuestionarios con promedio > 4 para calcular la proporcion.");
        }

        double porc45a5 = ((double) cantEntre45y5 / totalCuestionarios) * 100.0;
        System.out.printf("e. Porcentaje con promedio entre 4.5 y 5 respecto al total: %.2f%%%n", porc45a5);
    }
}
