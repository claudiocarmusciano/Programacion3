public class ejer2 {

    public static void main(String[] args) {
        int[] array = {2,4,5,7,9};
        System.out.print(estaEnArreglo(array, 5));

    }




    //Implemente, además, un algoritmo recursivo para buscar un elemento en un arreglo ordenado ascendentemente [1 2 3 …].
    public static boolean estaEnArreglo(int[] array, int buscado) {
    //    return estaEnArreglo(array, buscado, 0);
        return  busquedaBinariaRecursiva(array,5,0,array.length-1);
    }

    //Este ejercicio no está resuelto correctamente.
// Estás haciendo un recorrido lineal para buscar un arreglo en vez de una búsqueda binaria.
    public static boolean estaEnArreglo(int[] array, int buscado, int i) {
        if (i < array.length -1) {
            if (array[i] < buscado) return estaEnArreglo(array, buscado, i+1);
            else if (array[i] > buscado) return false;
            else if (array[i] == buscado) return true;
        }
        return false;
    }


    // Debería buscar el elemento del medio y, en base a la comparación, saber si vas a derecha o izquierda
    // Ésta es la forma correcta.
    public static boolean busquedaBinariaRecursiva(int [] A, int X, int inicio, int fin)
    {
        int medio;
        if (fin < inicio) return false; //sucederá si no se encuentra el elemento
        else {
            medio = (inicio + fin) / 2; //al ser medio un int, se realiza un truncado
            if (X > A[medio])
                return busquedaBinariaRecursiva(A, X, medio+1, fin);
            else
            if (X < A[medio])
                return busquedaBinariaRecursiva(A, X, inicio, medio -1);
            else
                return true;
        }
    }

}
