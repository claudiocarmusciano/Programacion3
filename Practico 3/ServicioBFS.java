import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioBFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitado;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitado = new HashMap<>();
	}

	public Iterator<Integer> ponerVisitadosFalse() {
		Iterator<Integer> iterador = grafo.obtenerVertices();
		while (iterador.hasNext()) {
			int vertice = iterador.next();
			this.visitado.put(vertice, false);
		}
		return this.visitado.keySet().iterator();
	}

	public List<Integer> bfsForest() {
		List<Integer> cola = new LinkedList<>();
		Iterator<Integer> iterador = this.ponerVisitadosFalse();
		while (iterador.hasNext()) {
			int vertice = iterador.next();
			if (this.visitado.get(vertice) == false) {
				cola.addAll(BFS_VISIT(vertice));
			}
		}
		return cola;
	}

	public ArrayList<Integer> BFS_VISIT(Integer vertice) {
		ArrayList<Integer> verticesVisitados = new ArrayList<>();
		visitado.put(vertice, true);
		verticesVisitados.add(vertice);

		while (!verticesVisitados.isEmpty()) {
			int verticeActual = verticesVisitados.remove(0);

			Iterator<Integer> iterador = grafo.obtenerAdyacentes(verticeActual);
			while (iterador.hasNext()) {
				int adyacente = iterador.next();
				if (this.visitado.get(adyacente) == false) {
					this.visitado.put(adyacente, true);
					verticesVisitados.add(adyacente);
				}
			}
		}
		return verticesVisitados;
	}

	public void imprimirBFSGrafo() {
		for (Integer vertice : this.visitado.keySet()) {
			System.out.print("Vertice: " + vertice + ", fue visitado: " + this.visitado.get(vertice));
			System.out.println();
		}
	}

}