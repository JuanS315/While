public class Control47 {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("Enteros positivos impares menores que 100 no divisibles por 7:");
        
        while (i < 100) {
            if (i % 7 != 0) {
                System.out.print(i + " ");
            }
            i += 2;
        }
        System.out.println();
    }
}
