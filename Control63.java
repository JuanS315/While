public class Control63 {
    public static void main(String[] args) {
        int totalAlumnos = 0;
        int cantMujeres = 0;
        int cantHombres = 0;
        double sumaEdadMujeres = 0;
        double sumaEdadHombres = 0;

        int solteros = 0;
        int casados = 0;
        int divorciados = 0;
        int viudos = 0;

        int esp1 = 0;
        int esp2 = 0;
        int esp3 = 0;
        int esp4 = 0;
        int esp5 = 0;

        int mujeresAdultas = 0;
        int hombresJovenes = 0;
        int hombresSolteros = 0;
        int mujeresSolteras = 0;

        char resp = 'S';
        
        while (resp == 'S') {
            totalAlumnos++;
            System.out.println("\nAlumno #" + totalAlumnos + ":");
            System.out.print("Edad: ");
            int edad = Integer.parseInt(System.console().readLine());
            System.out.print("Sexo (M/F): ");
            char sexo = System.console().readLine().toUpperCase().charAt(0);
            System.out.print("Estado Civil (1=Soltero, 2=Casado, 3=Divorciado, 4=Viudo): ");
            int ec = Integer.parseInt(System.console().readLine());
            System.out.print("Especialidad (1=Informatica, 2=Administracion, 3=Contaduria, 4=Mercadeo, 5=Otra): ");
            int esp = Integer.parseInt(System.console().readLine());

            if (sexo == 'F') {
                cantMujeres++;
                sumaEdadMujeres += edad;
                if (edad > 21) {
                    mujeresAdultas++;
                }
                if (ec == 1) {
                    mujeresSolteras++;
                }
            } else {
                cantHombres++;
                sumaEdadHombres += edad;
                if (edad > 17 && edad < 21) {
                    hombresJovenes++;
                }
                if (ec == 1) {
                    hombresSolteros++;
                }
            }

            if (ec == 1) {
                solteros++;
            } else if (ec == 2) {
                casados++;
            } else if (ec == 3) {
                divorciados++;
            } else if (ec == 4) {
                viudos++;
            }

            if (esp == 1) {
                esp1++;
            } else if (esp == 2) {
                esp2++;
            } else if (esp == 3) {
                esp3++;
            } else if (esp == 4) {
                esp4++;
            } else if (esp == 5) {
                esp5++;
            }

            System.out.print("Desea ingresar otro alumno? (S/N): ");
            resp = System.console().readLine().toUpperCase().charAt(0);
        }

        System.out.println("\n--- ESTADISTICAS DE LA ENCUESTA ---");
        if (cantMujeres > 0) {
            System.out.printf("a. Promedio de edad de las mujeres: %.2f%n", (sumaEdadMujeres / cantMujeres));
        } else {
            System.out.println("a. No se registraron mujeres.");
        }

        if (cantHombres > 0) {
            System.out.printf("b. Promedio de edad de los hombres: %.2f%n", (sumaEdadHombres / cantHombres));
        } else {
            System.out.println("b. No se registraron hombres.");
        }

        System.out.println("c. Cantidad de hombres: " + cantHombres + ", Cantidad de mujeres: " + cantMujeres);

        if (totalAlumnos > 0) {
            System.out.println("d. Porcentaje por estado civil:");
            System.out.printf("   Solteros: %.2f%%%n", ((double) solteros / totalAlumnos) * 100.0);
            System.out.printf("   Casados: %.2f%%%n", ((double) casados / totalAlumnos) * 100.0);
            System.out.printf("   Divorciados: %.2f%%%n", ((double) divorciados / totalAlumnos) * 100.0);
            System.out.printf("   Viudos: %.2f%%%n", ((double) viudos / totalAlumnos) * 100.0);

            System.out.println("e. Cantidad y porcentaje por especialidad:");
            System.out.printf("   Informatica: %d (%.2f%%)%n", esp1, ((double) esp1 / totalAlumnos) * 100.0);
            System.out.printf("   Administracion: %d (%.2f%%)%n", esp2, ((double) esp2 / totalAlumnos) * 100.0);
            System.out.printf("   Contaduria: %d (%.2f%%)%n", esp3, ((double) esp3 / totalAlumnos) * 100.0);
            System.out.printf("   Mercadeo: %d (%.2f%%)%n", esp4, ((double) esp4 / totalAlumnos) * 100.0);
            System.out.printf("   Otra: %d (%.2f%%)%n", esp5, ((double) esp5 / totalAlumnos) * 100.0);
        }

        if (cantMujeres > 0) {
            double porcMujeresAdultas = ((double) mujeresAdultas / cantMujeres) * 100.0;
            System.out.printf("f. Porcentaje de mujeres adultas (>21): %.2f%%%n", porcMujeresAdultas);
        }

        if (cantHombres > 0) {
            double porcHombresJovenes = ((double) hombresJovenes / cantHombres) * 100.0;
            System.out.printf("g. Porcentaje de hombres jovenes (18 a 20): %.2f%%%n", porcHombresJovenes);
        }

        System.out.println("h. Hombres solteros: " + hombresSolteros + ", Mujeres solteras: " + mujeresSolteras);
    }
}
