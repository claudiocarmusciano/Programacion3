public class ejer1 {

    //Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.

    //1. ¿Qué complejidad O tiene? (La complejidad en el peor caso) O(n),
    // hay que recorrer todo el arreglo si o si




    //2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
    //El problema de hacerlo recursivo es el uso que el sistema operativo tiene que hacer de la pila de ejecución
    // al generar registros de ejecución apilarlos y luego desapilarlos,
    // para un problema que no tiene ninguna ventaja al hacer de forma recursiva.
    //La complejidad es la misma que el iterativo por lo tanto no conviene que sea recursivo
    // (por el uso de la pila de ejecución)

    //3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
    //Nunca la verificación de si una lista está ordenada puede ser O(1) porque a la lista la tenés que recorrer en su totalidad.
    // Lo que cambia si vos querés aplicar este mismo algoritmo a una lista es que la complejidad empeora notablemente
    // porque para acceder a un elemento en una posición de la lista (con el get) tenés un código lineal.
    // Si lo querés resolver sobre una lista deberías cambiar el algoritmo para trabajar con iteradores en vez de índices

    public static boolean arregloOrdenado(int[] array){

        return arregloOrdenado(array,0);
    }
    public static boolean arregloOrdenado(int[] array, int indice) {
            if(indice ==array.length-1){
                return true;
            }
            else {
                if (array[indice] <= array[indice +1]) {
                    return arregloOrdenado(array, indice +1);
                }
                return false;
            }

    }

    public static void main(String[] args) {
        int[] array = {2,4,5,7,9,10};
        int[] array2 = {15,12,11,9,5,3,2,1,0};
        System.out.print(arregloOrdenado(array2));

    }
}
