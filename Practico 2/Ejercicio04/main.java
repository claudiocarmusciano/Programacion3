// Ejercicio 4.
// Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de Fibonacci.

package Ejercicio04;

public class main {
    public static void main(String[] args) {
        int n = 10; // El número de términos que se desea imprimir
        System.out.print("Los primeros " + n + " términos de la secuencia de Fibonacci son: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursivo(i) + " ");
        }
    }

    public static int fibonacciRecursivo(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

    // Otra forma mas eficiente:

    public static void secuenciaFibonacciEficiente(int numero, int anterior, int secuencia) {
        if (numero > 1) {
            System.out.println(" " + secuencia);
            secuenciaFibonacciEficiente(numero - 1, secuencia, secuencia + anterior);
        }
    }
}
