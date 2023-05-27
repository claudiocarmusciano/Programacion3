import java.util.Iterator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);
        grafo.agregarVertice(9);

        // grafo.agregarArco(1, 2, 10);
        // grafo.agregarArco(2, 4, 20);
        // grafo.agregarArco(1, 3, 30);
        // grafo.agregarArco(3, 5, 40);
        // grafo.agregarArco(1, 6, 40);
        // grafo.agregarArco(6, 7, 40);
        // grafo.agregarArco(7, 5, 40);
        // // los tres siguientes los agreguamos para testear circuito infinito
        // grafo.agregarArco(6, 3, 40);
        // grafo.agregarArco(3, 2, 40);
        // grafo.agregarArco(2, 1, 40);

        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 20);
        grafo.agregarArco(2, 4, 30);
        grafo.agregarArco(4, 1, 40);
        grafo.agregarArco(1, 5, 50);
        grafo.agregarArco(2, 5, 60);
        grafo.agregarArco(5, 4, 70);
        grafo.agregarArco(3, 5, 80);
        grafo.agregarArco(3, 6, 90);
        grafo.agregarArco(6, 5, 100);
        grafo.agregarArco(8, 5, 110);
        grafo.agregarArco(7, 3, 120);
        grafo.agregarArco(7, 6, 130);
        grafo.agregarArco(7, 8, 140);
        grafo.agregarArco(5, 5, 140);

        ((GrafoDirigido<Integer>) grafo).imprimirGrafo();

        System.out.println("-------------------------------");
        int vo = 1, vd = 2;
        System.out.println("Obtengo el arco con vertice Origen: " + vo + ", y vertice Destino: " + vd);
        System.out.println(grafo.obtenerArco(vo, vd));

        System.out.println("-------------------------------");
        int av = 3;
        System.out.print("Arcos del vértice (" + av + "): ");
        Iterator<Arco<Integer>> itArcos = grafo.obtenerArcos(av);
        while (itArcos.hasNext()) {
            Arco<Integer> a = itArcos.next();
            System.out.print(a + "  ");
        }
        System.out.println("");

        System.out.println("-------------------------------");
        int cantArcos = grafo.cantidadArcos();
        System.out.println("Cantidad de arcos: " + cantArcos);

        System.out.println("--------------------");

        // int verticeABorrar = 1;
        // System.out.println("Borro el vértice: " + verticeABorrar);
        // grafo.borrarVertice(verticeABorrar);
        // ((GrafoDirigido<Integer>) grafo).imprimirGrafo();

        System.out.println("Los vertices del grafo son:");
        Iterator<Integer> iterador = grafo.obtenerVertices();
        while (iterador.hasNext()) {
            Integer v = iterador.next();
            System.out.print(v + "  ");
        }
        System.out.println("");

        System.out.println("--------------------");
        int verticeAdy = 6;
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(verticeAdy);
        while (itAdyacentes.hasNext()) {
            Integer a = itAdyacentes.next();
            System.out.println("Adyacentes del vertice " + verticeAdy + ": " + a);
        }

        System.out.println("-------------------------------");
        System.out.println("Arcos del grafo: ");
        Iterator<Arco<Integer>> itA = grafo.obtenerArcos();
        while (itA.hasNext()) {
            Arco<Integer> a = itA.next();
            System.out.println(a + "  ");
        }

        System.out.println("-------------------------------");
        System.out.println("Grafo DFS:");
        ServicioDFS dfsGrafo = new ServicioDFS(grafo);
        // List<Integer> resultado = dfsGrafo.dfsForest();
        // dfsGrafo.imprimirDFSGrafo();
        System.out.println(dfsGrafo.dfsForest().toString());

        System.out.println("-------------------------------");
        System.out.println("Grafo BFS:");
        ServicioBFS bfsGrafo = new ServicioBFS(grafo);
        // List<Integer> resultadoBFS = bfsGrafo.bfsForest();
        // bfsGrafo.imprimirBFSGrafo();
        System.out.println(bfsGrafo.bfsForest().toString());

        System.out.println("-------------------------------");
        int origen = 2;
        int destino = 5;
        int limite = 6;
        System.out.println("Caminos posibles desde el vértice " + origen +
                " hasta el vértice " + destino + " con un límite de " + limite + " arcos.");

        ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, origen, destino, limite);
        List<List<Integer>> caminos = servicioCaminos.caminos();

        for (List<Integer> camino : caminos) {
            System.out.println(camino);
        }

    }

}
