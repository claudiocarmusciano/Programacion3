import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {

    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;

    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
    }

    public Iterator<Integer> pintarVerticesBlancos() {
        Iterator<Integer> iterador = grafo.obtenerVertices();
        while (iterador.hasNext()) {
            int vertice = iterador.next();
            this.colores.put(vertice, "white");
        }
        return this.colores.keySet().iterator();
    }

    public List<Integer> dfsForest() {
        List<Integer> verticesAPintar = new ArrayList<Integer>();
        Iterator<Integer> iterador = this.pintarVerticesBlancos();
        while (iterador.hasNext()) {
            int vertice = iterador.next();
            if (this.colores.get(vertice) == "white") {
                verticesAPintar.addAll(DFS_VISIT(vertice));
            }
        }
        return verticesAPintar;
    }

    public ArrayList<Integer> DFS_VISIT(Integer vertice) {
        ArrayList<Integer> verticesVisitados = new ArrayList<>();
        colores.put(vertice, "yellow");
        verticesVisitados.add(vertice);

        Iterator<Integer> iterador = this.grafo.obtenerAdyacentes(vertice);
        while (iterador.hasNext()) {
            int v = iterador.next();
            if (this.colores.get(v) == "white") {
                verticesVisitados.addAll(DFS_VISIT(v));
            }
        }
        colores.put(vertice, "black");
        return verticesVisitados;
    }

    public void imprimirDFSGrafo() {
        for (Integer vPintado : this.colores.keySet()) {
            System.out.print("Vertice: " + vPintado + ", color: " + this.colores.get(vPintado));
            System.out.println();
        }
    }
}
