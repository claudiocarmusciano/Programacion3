// Ejercicio 3.
// Implemente un algoritmo recursivo que convierta un número en notación decimal a su equivalente en notación binaria.

package Ejercicio03;

public class main {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("El binario de " + n + " es: " + binario(n));
    }

    public static int binario(int n) {
        if (n == 0)
            return 0;
        else
            return (n % 2 + 10 * binario(n / 2));
    }
}
