public class Control68 {
    public static void main(String[] args) {
        int encontrados = 0;
        int num = 2;
        System.out.println("Los tres primeros numeros perfectos son:");
        
        while (encontrados < 3) {
            int sumaDivisores = 0;
            int divisor = 1;
            
            while (divisor <= num / 2) {
                if (num % divisor == 0) {
                    sumaDivisores += divisor;
                }
                divisor++;
            }

            if (sumaDivisores == num) {
                encontrados++;
                System.out.println("Numero perfecto #" + encontrados + ": " + num);
            }
            num++;
        }
    }
}
