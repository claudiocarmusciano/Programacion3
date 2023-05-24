import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioBFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitado;
	private List<Integer> lista;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitado = new HashMap<>();
		this.lista = new LinkedList<>();
	}

	public Iterator<Integer> ponerVisitadosFalse() {
		// Iteramos sobre todos los vertices del grafo
		Iterator<Integer> iterador = grafo.obtenerVertices();
		while (iterador.hasNext()) {
			int vertice = iterador.next();
			// los ponemos en false
			this.visitado.put(vertice, false);
		}
		return this.visitado.keySet().iterator();
	}

	public List<Integer> bfsForest() {
		List<Integer> cola = new ArrayList<>();
		Iterator<Integer> iterador = this.ponerVisitadosFalse();
		while (iterador.hasNext()) {
			int vertice = iterador.next();
			if (this.visitado.get(vertice) == false) {
				cola.addAll(BFS_VISIT(vertice));
			}
		}
		return lista;
	}

	public ArrayList<Integer> BFS_VISIT(Integer vertice) {
		// Declaramos un ArrayList (verticesVisitados) para ir guardando los vertices
		// visitados
		ArrayList<Integer> verticesVisitados = new ArrayList<>();
		// Marcamos el primer vertice como visitado y lo agragamos a la lista de
		// verticesVisitados
		visitado.put(vertice, true);
		verticesVisitados.add(vertice);
		lista.add(vertice);

		// Mientras haya vertices en la cola (verticesVisitados), retira al primero
		while (!verticesVisitados.isEmpty()) {
			Integer verticeActual = verticesVisitados.get(0);
			verticesVisitados.remove(verticeActual);

			// Obtenemos los adyacentes de ese vertice, los iteramos, los marcamos como
			// visitados y los agregamos a la cola (verticesVisitados)
			Iterator<Integer> iterador = grafo.obtenerAdyacentes(verticeActual);
			while (iterador.hasNext()) {
				int adyacente = iterador.next();
				if (this.visitado.get(adyacente) == false) {
					this.visitado.put(adyacente, true);
					verticesVisitados.add(adyacente);
					lista.add(adyacente);
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
