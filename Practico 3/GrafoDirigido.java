import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        // Verifico que no contenga ese vertice y lo agrego al
        if (!contieneVertice(verticeId)) {
            vertices.put(verticeId, new ArrayList<Arco<T>>());
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (contieneVertice(verticeId1)) {
            Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
            vertices.get(verticeId1).add(arco);
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (this.contieneVertice(verticeId)) {
            this.vertices.remove(verticeId);
        }
        Iterator<?> iterador = this.obtenerArcos();
        while (iterador.hasNext()) {
            Arco<?> a = (Arco<?>) iterador.next();
            if (a.getVerticeDestino() == verticeId) {
                this.borrarArco(a.getVerticeOrigen(), verticeId);
            }
        }
    }

    // @Override
    /////////////// OTRA FORMA//////////////////////
    // public void borrarVertice(int verticeId) {
    // if (contieneVertice(verticeId)) {
    // // Borro el vertice solicitado:
    // vertices.remove(verticeId);
    // // Cargo un Set con los vertices que quedaron
    // Set<Integer> keysVertices = vertices.keySet();
    // // Recorro cada uno de esos vertices
    // for (Integer keyVertice : keysVertices) {
    // // Borro los arcos cuyo 'verticeDestino' == verticeId
    // borrarArco(keyVertice, verticeId);
    // }
    // }
    // }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1)) {
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
        if (contieneVertice(verticeId1)) {
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
        // Guardo en vertices los valores de
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
        ArrayList<Arco<T>> arcos = vertices.get(verticeId);
        LinkedList<Integer> adyacentes = new LinkedList<>();
        if (contieneVertice(verticeId)) {
            if (arcos != null) {
                for (Arco<T> arco : arcos) {
                    adyacentes.add(arco.getVerticeDestino());
                }
            }
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for (int verticeOrigen : vertices.keySet()) {
            for (Arco<T> arco : vertices.get(verticeOrigen)) {
                int verticeDestino = arco.getVerticeDestino();
                arcos.add(new Arco<T>(verticeOrigen, verticeDestino, arco.getEtiqueta()));
            }
        }
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
