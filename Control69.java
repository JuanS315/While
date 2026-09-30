public class Control69 {
    public static void main(String[] args) {
        System.out.print("Ingrese el primer numero (A): ");
        int a = Integer.parseInt(System.console().readLine());
        System.out.print("Ingrese el segundo numero (B): ");
        int b = Integer.parseInt(System.console().readLine());

        int sumaA = 0;
        int d = 1;
        
        while (d <= a / 2) {
            if (a % d == 0) {
                sumaA += d;
            }
            d++;
        }

        int sumaB = 0;
        d = 1;
        
        while (d <= b / 2) {
            if (b % d == 0) {
                sumaB += d;
            }
            d++;
        }

        System.out.println("Suma de divisores propios de " + a + " = " + sumaA);
        System.out.println("Suma de divisores propios de " + b + " = " + sumaB);

        if (sumaA == b && sumaB == a && a != b) {
            System.out.println("Los numeros " + a + " y " + b + " SON NUMEROS AMIGOS.");
        } else {
            System.out.println("Los numeros " + a + " y " + b + " NO son numeros amigos.");
        }

        System.out.println("\nPrimeros pares de numeros amigos conocidos:");
        int n1 = 2;
        int paresEncontrados = 0;
        
        while (paresEncontrados < 3) {
            int sum1 = 0;
            int div = 1;
            
            while (div <= n1 / 2) {
                if (n1 % div == 0) {
                    sum1 += div;
                }
                div++;
            }

            int n2 = sum1;
            if (n2 > n1) {
                int sum2 = 0;
                int div2 = 1;
                
                while (div2 <= n2 / 2) {
                    if (n2 % div2 == 0) {
                        sum2 += div2;
                    }
                    div2++;
                }

                if (sum2 == n1) {
                    paresEncontrados++;
                    System.out.println("Par #" + paresEncontrados + ": (" + n1 + ", " + n2 + ")");
                }
            }
            n1++;
        }
    }
}
