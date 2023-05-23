import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ServicioCaminos {

    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;

    private List<List<Integer>> resultado;
    private List<Integer> camino;

    private Set<Arco<?>> arcosVisitados; // Utilizamos set porque no permite duplicados

    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;

        this.resultado = new LinkedList<>();
        this.camino = new ArrayList<>();

        // Se utiliza para almacenar los arcos visitados y ver si un arco ya ha sido
        /// visitado o no.
        this.arcosVisitados = new HashSet<>();

    }

    public List<List<Integer>> caminos() {

        // Inicializamos el contador de arcos
        Integer contador = 1;
        camino.add(origen);
        camino(origen, destino, contador);

        return resultado;
    }

    private void camino(int vo, int vd, int contador) {

        // Si superó el límite de arcos, termino recursión
        if (contador > lim) {
            return;
        }

        Iterator<Integer> ady = grafo.obtenerAdyacentes(vo);
        while (ady.hasNext() && camino.size() <= lim) {
            Integer ad = ady.next();
            // Obtengo el arco, controlo con el if que no este visitado y lo agrego
            Arco<?> arco = grafo.obtenerArco(vo, ad);
            if (!arcosVisitados.contains(arco)) {
                arcosVisitados.add(arco); // Agrego el arco a arcosVisitados
                camino.add(ad); // Agrego el adyacente si el arco no esta visitado

                if (ad == destino) {
                    List<Integer> copiaCamino = new LinkedList<>(camino);
                    resultado.add(copiaCamino);
                } else {
                    camino(ad, destino, contador + 1);
                }
                camino.remove(camino.size() - 1);
                arcosVisitados.remove(arco);
            }
        }
    }
}
