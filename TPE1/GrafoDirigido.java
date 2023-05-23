import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        // Verifico que no contenga ese vertice y lo agrego
        if (!contieneVertice(verticeId)) {
            vertices.put(verticeId, new ArrayList<Arco<T>>());
        }
    }

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

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        // verificamos que existan ambos vertices y agregamos el arco
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
            vertices.get(verticeId1).add(arco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // verificamos que existan ambos vertices y borramos el arco
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Arco<T> arco = obtenerArco(verticeId1, verticeId2);
            vertices.get(verticeId1).remove(arco);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return (vertices.containsKey(verticeId));
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return (obtenerArco(verticeId1, verticeId2) != null);
    }

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

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int arcos = 0;
        Set<Integer> keysVertices = vertices.keySet();
        for (Integer keyVertice : keysVertices) {
            arcos += vertices.get(keyVertice).size();
        }
        return arcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        Set<Integer> keysVertices = vertices.keySet();
        return keysVertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (contieneVertice(verticeId)) {
            Iterator<Arco<T>> arcos = vertices.get(verticeId).iterator();
            return new IteratorAdyacentes<T>(arcos);
        }
        return null;
    }

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
