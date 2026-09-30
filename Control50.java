public class Control50 {
    public static void main(String[] args) {
        long suma = 0;
        int num = 98;
        
        while (num <= 1002) {
            suma += num;
            num += 2;
        }
        System.out.println("Suma de todos los numeros pares comprendidos entre 97 y 1003: " + suma);
    }
}
