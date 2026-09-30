public class Control46 {
    public static void main(String[] args) {
        int n = 0;
        int k = 0;
        
        while (k >= n || n <= 0 || k <= 0) {
            System.out.print("Ingrese N (entero positivo): ");
            n = Integer.parseInt(System.console().readLine());
            System.out.print("Ingrese K (entero positivo menor que N): ");
            k = Integer.parseInt(System.console().readLine());
            if (k >= n || n <= 0 || k <= 0) {
                System.out.println("Error: K debe ser menor que N y ambos positivos.");
            }
        }

        int actual = n;
        System.out.println("Secuencia descendente:");
        
        while (actual >= k) {
            System.out.print(actual);
            if (actual > k) {
                System.out.print(", ");
            }
            actual--;
        }
        System.out.println();
    }
}