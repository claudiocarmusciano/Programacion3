// Ejercicio6.
// Implemente un algoritmo de ordenamiento por selección en un arreglo.
// Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.

package Ejercicio06;

public class main {
    public static void main(String[] args) {
        int[] arreglo = { 4, 89, 21, 12, 76, 98 };
        int largo = arreglo.length;
        int inicio = 0;
        int fin = largo - 1;
        // System.out.println("El arreglo (" + toString(arreglo) + "), ordenado,
        // quedaría así -->> " +
        // toString(ordenamientoSeleccionRecursivo(arreglo, largo, inicio, fin)));
    }

    // está mal, no usar recursividad, NO ROMPERSE LA CABEZA
    // public static int[] ordenamientoSeleccionRecursivo(int[] arreglo, int largo,
    // int inicio, int fin) {
    // if (inicio > largo - 1) {
    // return arreglo;
    // } else if (arreglo[inicio + 1] < arreglo[inicio]) {
    // int temp = arreglo[inicio];
    // arreglo[inicio] = arreglo[inicio + 1];
    // arreglo[inicio + 1] = temp;
    // } else
    // return ordenamientoSeleccionRecursivo(arreglo, largo, inicio + 1, fin);
    // return arreglo;
    // }

    public static String toString(int[] arreglo) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
