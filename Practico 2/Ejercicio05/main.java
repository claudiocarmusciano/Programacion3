// Ejercicio 5.
// Dado un arreglo ordenado de números distintos A 
// se desea construir un algoritmo que determine si alguno 
// de los elementos de dicho arreglo contiene un valor igual a 
// la posición en la cuál se encuentra, es decir, A[i] = i.

package Ejercicio05;

public class main {
    public static void main(String[] args) {
        int[] arreglo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int largo = arreglo.length;
        int n = 0;
        if (contieneRecursivo(arreglo, largo)) {
            System.out.println("El arreglo contiene ese número en esa posición");
        } else {
            System.out.println("El arreglo NO contiene ese número en esa posición");
        }
    }

    public static boolean contieneRecursivo(int[] arreglo, int largo) {
        if (arreglo[largo - 1] == largo - 1)
            return true;
        else if (largo <= 1)
            return false;
        else
            return contieneRecursivo(arreglo, largo - 1);
    }

    // refactorizar para usar busqueda binaria //

    public static boolean contieneRecursivoBinaria(int[] arreglo, int pos_ini, int pos_fin) {
        int largo = arreglo.length;
        if (arreglo[largo - 1] == largo - 1)
            return true;
        else if (largo <= 1)
            return false;
        else
            return contieneRecursivo(arreglo, largo - 1);
    }

}
