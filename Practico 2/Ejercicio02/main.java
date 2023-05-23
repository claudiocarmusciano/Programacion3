// Ejercicio 2.
// Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado ascendentemente.

package Ejercicio02;

public class main {
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 19, 30, 40};
        if (binariaRecursiva(arreglo, 40, 0, arreglo.length)) {
            System.out.println("El elemento está en el arreglo ordenado");
        } else {
            System.out.println("El elemento NO está en el arreglo ordenado");
        }
    }

    private static boolean binariaRecursiva(int[] arreglo, int n, int inicio, int fin) {
    
        if (fin<inicio)
            return false;
        else {
            int medio=(inicio+fin)/2;
            if (n>arreglo[medio]) {
                return (binariaRecursiva(arreglo, n, medio+1, fin));
            } else {
                if (n<arreglo[medio]) {
                    return (binariaRecursiva(arreglo, n, inicio, medio-1));
                } else {
                    return true;
                }
            }
        }
    }
}
