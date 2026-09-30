public class Control59 {
    public static void main(String[] args) {

        double minProg = 999;
        double sumaProg = 0;
        int cantProg = 0;

        int inglesNoPresento = 0;
        int inglesSiPresento = 0;

        int matPresentaron = 0;
        int matReprobaron = 0;

        int aproboTodas = 0;
        int totalAlumnos = 0;
        char resp = 'S';
        
        while (resp == 'S') {
            totalAlumnos++;
            System.out.println("\nAlumno #" + totalAlumnos + ":");

            System.out.print("Presento Matematica? (1=Si, 0=No): ");
            int presMat = Integer.parseInt(System.console().readLine());
            double notaMat = -1;
            if (presMat == 1) {
                System.out.print("Nota Matematica (0-20): ");
                notaMat = Double.parseDouble(System.console().readLine());
                matPresentaron++;
                if (notaMat < 10) {
                    matReprobaron++;
                }
            }

            System.out.print("Presento Programacion? (1=Si, 0=No): ");
            int presProg = Integer.parseInt(System.console().readLine());
            double notaProg = -1;
            if (presProg == 1) {
                System.out.print("Nota Programacion (0-20): ");
                notaProg = Double.parseDouble(System.console().readLine());
                cantProg++;
                sumaProg += notaProg;
                if (notaProg < minProg) {
                    minProg = notaProg;
                }
            }

            System.out.print("Presento Ingles? (1=Si, 0=No): ");
            int presIng = Integer.parseInt(System.console().readLine());
            double notaIng = -1;
            if (presIng == 1) {
                System.out.print("Nota Ingles (0-20): ");
                notaIng = Double.parseDouble(System.console().readLine());
                inglesSiPresento++;
            } else {
                inglesNoPresento++;
            }

            if (presMat == 1 && notaMat >= 10 && presProg == 1 && notaProg >= 10 && presIng == 1 && notaIng >= 10) {
                aproboTodas++;
            }

            System.out.print("Desea ingresar otro alumno? (S/N): ");
            resp = System.console().readLine().toUpperCase().charAt(0);
        }

        System.out.println("\n--- RESULTADOS GENERALES ---");
        if (cantProg > 0) {
            System.out.printf("a. Nota menor de Programacion: %.2f%n", minProg);
            System.out.printf("d. Promedio general en Programacion: %.2f%n", (sumaProg / cantProg));
        } else {
            System.out.println("a. Nota menor de Programacion: Ninguna");
            System.out.println("d. Promedio general en Programacion: Sin datos");
        }

        if (inglesSiPresento > 0) {
            double porcIng = ((double) inglesNoPresento / inglesSiPresento) * 100.0;
            System.out.printf("b. Porcentaje no presentaron ingles respecto a los que si: %.2f%%%n", porcIng);
        } else {
            System.out.println("b. No hubo alumnos que presentaran Ingles.");
        }

        System.out.println("c. Alumnos que aprobaron todas las materias: " + aproboTodas);

        if (matPresentaron > 0) {
            double porcMat = ((double) matReprobaron / matPresentaron) * 100.0;
            System.out.printf("e. Porcentaje reprobaron Matematica respecto a los que presentaron: %.2f%%%n", porcMat);
        } else {
            System.out.println("e. Ningun alumno presento examen de Matematica.");
        }
    }
}
