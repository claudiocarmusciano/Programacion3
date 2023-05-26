import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    /*
     * Complejidad método agregarVertice: O(1), dado que el método contieneVertice
     * utiliza HashMap
     * y éste está considerado con una complejidad O(1), y el put también es O(1)
     */
    @Override
    public void agregarVertice(int verticeId) {
        // Verifico que no contenga ese vertice y lo agrego
        if (!contieneVertice(verticeId)) {
            vertices.put(verticeId, new ArrayList<Arco<T>>());
        }
    }

    /*
     * Complejidad método borrarVertice: O(n), siendo n la cantidad de arcos a
     * eliminar que
     * se dirijen al vértice eliminado.
     */
    @Override
    public void borrarVertice(int verticeId) {
        // Si contiene el vértice lo borramos
        if (this.contieneVertice(verticeId)) {
            this.vertices.remove(verticeId);
        }

        // Obtenemos todos los arcos con un iterador, y borro aquellos que tienen el
        // verticeId como destino
        Iterator<?> iterador = this.obtenerArcos();
        while (iterador.hasNext()) {
            Arco<?> a = (Arco<?>) iterador.next();
            if (a.getVerticeDestino() == verticeId) {
                this.borrarArco(a.getVerticeOrigen(), verticeId);
            }
        }
    }

    /*
     * Complejidad método agregarArco: O(1) dado que el método contieneVertice
     * utiliza HashMap
     * y éste está considerado con una complejidad O(1), y el add al hashMap
     * vertices también es O(1)
     */
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        // verificamos que existan ambos vertices y agregamos el arco
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
            vertices.get(verticeId1).add(arco);
        }
    }

    /*
     * Complejidad método borrarArco: O(1) dado que el método contieneVertice
     * utiliza HashMap
     * y éste está considerado con una complejidad O(1), y el remove al hashMap
     * vertices también es O(1)
     */
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // verificamos que existan ambos vertices y borramos el arco
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Arco<T> arco = obtenerArco(verticeId1, verticeId2);
            vertices.get(verticeId1).remove(arco);
        }
    }

    /*
     * Complejidad del método contieneVertice: O(1), dado que el acceso a
     * un key de hashMap es considerado O(1)
     */
    @Override
    public boolean contieneVertice(int verticeId) {
        return (vertices.containsKey(verticeId));
    }

    /*
     * Complejidad del método existeArco: O(n), dado que
     * el método utilizado dentro de éste (obtenerArco) es O(n).
     */
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return (obtenerArco(verticeId1, verticeId2) != null);
    }

    /*
     * Complejidad del método obtenerArco: O(n), donde n son los arcos que contiene
     * el grafo, y en el peor de los casos habrá
     * que recorrer todos los arcos para encontrar el buscado.
     */
    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        // Verificamos que existan ambos vértices
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            // Recorremos los arcos del verticeId1 y si el vértice destino = verticeId2 lo
            // retornamos
            for (Arco<T> arco : vertices.get(verticeId1)) {
                if (arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
            }
        }
        return null;
    }

    /*
     * Complejidad del método cantidadVertices: O(1), dado que
     * solamente retorna la medida (size) de un hashMap.
     */
    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    /*
     * Complejidad del método cantidadArcos: O(n), donde n son todos los vértices
     */
    @Override
    public int cantidadArcos() {
        int arcos = 0;
        Set<Integer> keysVertices = vertices.keySet();
        for (Integer keyVertice : keysVertices) {
            arcos += vertices.get(keyVertice).size();
        }
        return arcos;
    }

    /*
     * Complejidad del método obtenerVertices: O(1), dado que
     * simplemente se instancia la clase iterator.
     */
    @Override
    public Iterator<Integer> obtenerVertices() {
        Set<Integer> keysVertices = vertices.keySet();
        return keysVertices.iterator();
    }

    /*
     * Complejidad del método obtenerVertices: O(1), dado que
     * simplemente se instancia la clase iterator.
     */
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (contieneVertice(verticeId)) {
            Iterator<Arco<T>> arcos = vertices.get(verticeId).iterator();
            return new IteratorAdyacentes<T>(arcos);
        }
        return null;
    }

    /*
     * Complejidad del método obtenerArcos: O(nˆ2), donde n es el número de
     * vertices y, en el peor de los casos, todos los vertices pueden estar
     * conectados entre todos.
     */
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        // Creamos un ArrayList vacio para guardar los arcos
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        // Recorremos los vértices del grafo
        for (int verticeOrigen : vertices.keySet()) {
            // Obtenemos los vertices del verticeOrigen
            for (Arco<T> arco : vertices.get(verticeOrigen)) {
                int verticeDestino = arco.getVerticeDestino();
                // Para cada vertice adyacente creamos un nuevo arco y lo agregamos a la lista
                arcos.add(new Arco<T>(verticeOrigen, verticeDestino, arco.getEtiqueta()));
            }
        }
        // Devolvemos el iterador de la lista
        return arcos.iterator();
    }

    /*
     * Complejidad del método obtenerArcos: O(1), dado que acceder a una clave es
     * O(1)
     * y simplemente se está instanciando un iterador.
     */
    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (this.contieneVertice(verticeId)) {
            return vertices.get(verticeId).iterator();
        }
        return null;
    }

    public void imprimirGrafo() {
        for (int v : vertices.keySet()) {
            System.out.print(v + ": ");

            for (Arco<T> arco : vertices.get(v)) {
                System.out.print(arco.getVerticeDestino() + "(" + arco.getEtiqueta() + ") ");
            }

            System.out.println();
        }
    }

}
