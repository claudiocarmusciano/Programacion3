// Ejercicio 1.
// Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.

package Ejercicio01;

public class main {
    public static void main(String[] args) {
        int[] arreglo = { 1, 2, 3, 4, 5, 19, 30, 40 };
        if (isOrdered(arreglo, arreglo.length)) {
            System.out.println("El arreglo está ordenado.");
        } else {
            System.out.println("El arreglo NO está ordenado");
        }
    }

    private static boolean isOrdered(int[] arreglo, int n) {
        if (n == 1)
            return true;

        if (isOrdered(arreglo, n - 1)) {
            return (arreglo[n - 1] >= arreglo[n - 2]);
        }

        return false;
    }
}
