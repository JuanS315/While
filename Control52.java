public class Control52 {
    public static void main(String[] args) {
        int totalPersonas = 100;
        int i = 1;

        double pesoNinos = 0;
        int cantNinos = 0;

        double pesoJovenes = 0;
        int cantJovenes = 0;

        double pesoAdultos = 0;
        int cantAdultos = 0;

        double pesoViejos = 0;
        int cantViejos = 0;

        System.out.print("Ingrese el total de personas para el muestreo (100 segun el ejercicio): ");
        totalPersonas = Integer.parseInt(System.console().readLine());
        
        while (i <= totalPersonas) {
            System.out.println("Persona " + i + ":");
            System.out.print("Edad: ");
            int edad = Integer.parseInt(System.console().readLine());
            System.out.print("Peso: ");
            double peso = Double.parseDouble(System.console().readLine());

            if (edad >= 0 && edad <= 12) {
                pesoNinos += peso;
                cantNinos++;
            } else if (edad >= 13 && edad <= 29) {
                pesoJovenes += peso;
                cantJovenes++;
            } else if (edad >= 30 && edad <= 59) {
                pesoAdultos += peso;
                cantAdultos++;
            } else if (edad >= 60) {
                pesoViejos += peso;
                cantViejos++;
            }
            i++;
        }

        System.out.println("\nPromedios de peso obtenidos:");
        if (cantNinos > 0) {
            System.out.printf("Ninos (0-12 anos): %.2f kg (Cantidad: %d)%n", (pesoNinos / cantNinos), cantNinos);
        } else {
            System.out.println("Ninos (0-12 anos): Sin registros");
        }

        if (cantJovenes > 0) {
            System.out.printf("Jovenes (13-29 anos): %.2f kg (Cantidad: %d)%n", (pesoJovenes / cantJovenes), cantJovenes);
        } else {
            System.out.println("Jovenes (13-29 anos): Sin registros");
        }

        if (cantAdultos > 0) {
            System.out.printf("Adultos (30-59 anos): %.2f kg (Cantidad: %d)%n", (pesoAdultos / cantAdultos), cantAdultos);
        } else {
            System.out.println("Adultos (30-59 anos): Sin registros");
        }

        if (cantViejos > 0) {
            System.out.printf("Viejos (60 en adelante): %.2f kg (Cantidad: %d)%n", (pesoViejos / cantViejos), cantViejos);
        } else {
            System.out.println("Viejos (60 en adelante): Sin registros");
        }
    }
}
