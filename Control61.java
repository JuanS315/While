public class Control61 {
    public static void main(String[] args) {
        System.out.print("Ingrese el multiplicador: ");
        int multiplicador = Integer.parseInt(System.console().readLine());
        System.out.print("Ingrese el multiplicando: ");
        int multiplicando = Integer.parseInt(System.console().readLine());

        int sum = 0;
        int m1 = multiplicador;
        int m2 = multiplicando;

        System.out.println("\nMultiplicador | Multiplicando");
        System.out.println("----------------------------");
        
        while (m1 >= 1) {
            System.out.printf("%-13d | %-13d", m1, m2);
            if (m1 % 2 != 0) {
                sum += m2;
                System.out.print(" -> Se suma " + m2);
            }
            System.out.println();
            m1 = m1 / 2;
            m2 = m2 * 2;
        }

        System.out.println("----------------------------");
        System.out.println("Resultado de la multiplicacion: " + sum);
    }
}
