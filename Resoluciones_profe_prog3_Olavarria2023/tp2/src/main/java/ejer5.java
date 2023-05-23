public class ejer5 {

    //Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
    //determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
    //cuál se encuentra, es decir, A[i] = i.
    //1) Construir un algoritmo recursivo que responda a dicha verificación.
    //2) Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])

    public static void main(String[] args) {
        int[] array = {-3, -1, 0, 2, 4, 6, 10};
    //    System.out.print(array[4]);
        System.out.println(cumpleCondicion(array));
        //otra forma
        System.out.println(cumpleCondicion2(array,0,array.length - 1));

    }

    private static boolean cumpleCondicion(int[] array) {
        return  cumpleCondicion(array,0);
    }

    private static boolean cumpleCondicion(int[] array, int i) {
        if (i <= array.length - 1) {
            if (array[i] == i) {
                return true;
            } else {
                return cumpleCondicion(array, i + 1);
            }
        }
        return false;
    }

    private static boolean cumpleCondicion2(int[] array, int izq, int der) {
        if (izq > der ) {
            return false;
        }
        else{
            int medio = (izq + der )/2;
            if (array[medio] == medio) {// A[i] = i
                return true;
            } else if (array[medio] < medio){// A[i] < i ===> Explorar sólo la derecha
                return cumpleCondicion2(array, medio + 1,der);
                }
            else{// A[i] >i ===> Explorar sólo la izquierda
                return cumpleCondicion2(array, izq,medio-1);
            }
        }
    }
}
