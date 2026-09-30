public class Control49 {
    public static void main(String[] args) {
        int totalPersonas = 100;
        int i = 1;
        int cantTresCorrectas = 0;
        int cantSolo1y2 = 0;
        int cantSolo1y3 = 0;
        int cantSolo2y3 = 0;
        int cantP1PorLoMenos = 0;
        int cantP2PorLoMenos = 0;
        int cantP3PorLoMenos = 0;
        int cantNinguna = 0;

        System.out.print("Ingrese cantidad de personas a evaluar (100 segun el ejercicio): ");
        totalPersonas = Integer.parseInt(System.console().readLine());
        
        while (i <= totalPersonas) {
            System.out.println("Persona " + i + ":");
            System.out.print("Pregunta 1 correcta? (1=Si, 0=No): ");
            int p1 = Integer.parseInt(System.console().readLine());
            System.out.print("Pregunta 2 correcta? (1=Si, 0=No): ");
            int p2 = Integer.parseInt(System.console().readLine());
            System.out.print("Pregunta 3 correcta? (1=Si, 0=No): ");
            int p3 = Integer.parseInt(System.console().readLine());

            if (p1 == 1 && p2 == 1 && p3 == 1) {
                cantTresCorrectas++;
            }
            if (p1 == 1 && p2 == 1 && p3 == 0) {
                cantSolo1y2++;
            }
            if (p1 == 1 && p2 == 0 && p3 == 1) {
                cantSolo1y3++;
            }
            if (p1 == 0 && p2 == 1 && p3 == 1) {
                cantSolo2y3++;
            }
            if (p1 == 1) {
                cantP1PorLoMenos++;
            }
            if (p2 == 1) {
                cantP2PorLoMenos++;
            }
            if (p3 == 1) {
                cantP3PorLoMenos++;
            }
            if (p1 == 0 && p2 == 0 && p3 == 0) {
                cantNinguna++;
            }
            i++;
        }

        System.out.println("\nResultados:");
        System.out.println("a. Respondieron correctamente las tres preguntas: " + cantTresCorrectas);
        System.out.println("b. Respondieron correctamente solamente la 1ra y 2da: " + cantSolo1y2);
        System.out.println("c. Respondieron correctamente solamente la 1ra y 3ra: " + cantSolo1y3);
        System.out.println("d. Respondieron correctamente solamente la 2da y 3ra: " + cantSolo2y3);
        System.out.println("e. Respondieron correctamente la 1ra pregunta por lo menos: " + cantP1PorLoMenos);
        System.out.println("f. Respondieron correctamente la 2da pregunta por lo menos: " + cantP2PorLoMenos);
        System.out.println("g. Respondieron correctamente la 3ra pregunta por lo menos: " + cantP3PorLoMenos);
        System.out.println("h. No respondieron correctamente ninguna pregunta: " + cantNinguna);
    }
}