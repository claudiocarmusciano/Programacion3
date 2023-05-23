public class ejer6 {

    public static void main(String[] args) {
        int[] array = {3, 1, 0, 2, 4, -6, 10};
        //////////////////////////////////////////////////
        int[] arrayOrdenado = algoritmoDeBurbujeo(array);
        for (int i:arrayOrdenado) {// es un foreach
            System.out.print(" "+i);
        }
        System.out.println();
        /////////////////////////////////////////////
        int[] arrayOrdenado2 = ordenarPorSeleccion(array);
       for (int i=0;i<arrayOrdenado2.length;i++){
           System.out.print(" "+arrayOrdenado2[i]);
       }
    }
    //Cuando una lista ya está ordenada, a diferencia del ordenamiento por inserción que pasará por la lista una vez y encontrará que no hay necesidad de intercambiar las posiciones de los elementos,
    // el método de ordenación por burbuja está forzado a pasar por dichas comparaciones,
    // lo que hace que su complejidad sea cuadrática en el mejor de los casos.
    // Esto lo cataloga como uno de los algoritmos de ordenación más ineficientes que existen,
    // aunque para muchos programadores sea el más sencillo de implementar.
    // Tiene complejidad O(n²)
    public static int[] algoritmoDeBurbujeo(int[] arr) {
        boolean intercambiado = true;
        int j = 0;
        int tmp;
        while (intercambiado) {
            intercambiado = false;
            j++;
            for (int i=0; i<arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    intercambiado = true;
                }
            }
        }
        return arr;
    }

    // Tiene complejidad O(n²). requiere O(n²) operaciones para ordenar una lista de n elementos

    //Su funcionamiento es el siguiente:
    //Buscar el mínimo elemento de la lista
    //Intercambiarlo con el primero
    //Buscar el siguiente mínimo en el resto de la lista
    //Intercambiarlo con el segundo
    //Y en general:
    //Buscar el mínimo elemento entre una posición i y el final de la lista
    //Intercambiar el mínimo con el elemento de la posición i
    public static int[] ordenarPorSeleccion(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    // ...intercambiarlos, es decir, mover el actual a la derecha y el de la derecha al actual
                    int temporal = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }
        return arreglo;
    }
}
