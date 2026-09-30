public class Control76 {
    public static void main(String[] args) {
        System.out.print("Ingrese cantidad de grupos (g): ");
        int g = Integer.parseInt(System.console().readLine());

        double sumaPromediosGrupos = 0;
        int gIdx = 1;

        if (g > 0) {
            while (gIdx <= g) {
                System.out.println("\n==========================================");
                System.out.println("GRUPO #" + gIdx);
                System.out.print("Cantidad de alumnos en el grupo (n): ");
                int n = Integer.parseInt(System.console().readLine());

                double sumaPromediosAlumnos = 0;
                int aIdx = 1;

                if (n > 0) {
                    while (aIdx <= n) {
                        System.out.println("\n--- Alumno #" + aIdx + " del Grupo #" + gIdx + " ---");
                        System.out.print("Nombre del alumno: ");
                        String nomAlumno = System.console().readLine();
                        System.out.print("Cantidad de materias del alumno (m): ");
                        int m = Integer.parseInt(System.console().readLine());

                        double sumaPromediosMaterias = 0;
                        int mIdx = 1;

                        if (m > 0) {
                            while (mIdx <= m) {
                                System.out.println("Materia #" + mIdx + ":");
                                double sumaNotas = 0;
                                int nIdx = 1;
                                while (nIdx <= 3) {
                                    System.out.print("  Calificacion " + nIdx + ": ");
                                    double calif = Double.parseDouble(System.console().readLine());
                                    sumaNotas += calif;
                                    nIdx++;
                                }

                                double promMateria = sumaNotas / 3.0;
                                sumaPromediosMaterias += promMateria;
                                System.out.printf("  -> Promedio de materia #%d: %.2f%n", mIdx, promMateria);
                                mIdx++;
                            }
                        }

                        double promAlumno = (m > 0) ? (sumaPromediosMaterias / m) : 0;
                        System.out.printf(">>> Promedio del alumno %s: %.2f%n", nomAlumno, promAlumno);
                        sumaPromediosAlumnos += promAlumno;

                        aIdx++;
                    }
                }

                double promGrupo = (n > 0) ? (sumaPromediosAlumnos / n) : 0;
                System.out.printf("\n*** PROMEDIO DEL GRUPO #%d: %.2f ***%n", gIdx, promGrupo);
                sumaPromediosGrupos += promGrupo;

                gIdx++;
            }
        }

        double promGeneral = (g > 0) ? (sumaPromediosGrupos / g) : 0;
        System.out.printf("\n==========================================%n");
        System.out.printf("PROMEDIO GENERAL DE TODOS LOS GRUPOS: %.2f%n", promGeneral);
    }
}
