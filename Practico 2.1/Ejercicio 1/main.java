public class main {
    public static void main(String[] args) {
        Tree arbol = new Tree(6);
        arbol.add(2);
        arbol.add(10);
        arbol.add(1);
        arbol.add(4);
        arbol.add(8);
        arbol.add(11);
        arbol.add(7);
        arbol.add(9);

        System.out.println();
        System.out.println("Root del arbol: " + arbol.getRoot());

        System.out.println();
        System.out.println("Arbol PreOrder:");
        arbol.printPreOrder();

        System.out.println();
        System.out.println();
        System.out.println("Arbol PosOrder:");
        arbol.printPosOrder();

        System.out.println();
        System.out.println();
        System.out.println("Arbol InOrder:");
        arbol.printInOrder();

        System.out.println(" ");
        System.out.println("Raíz del árbol: " + arbol.getRoot());

        int elemento = 11;
        System.out.println("Tiene el elemento: " + elemento + " ? = " + arbol.hasElem(elemento));

        System.out.println(" ");
        if (arbol.isEmpty())
            System.out.println("El árbol está vacío.");
        else
            System.out.println("El árbol NO está vacío.");

        System.out.println(" ");
        System.out.println("La frontera del arbol es: " + arbol.getFrontera());

        System.out.println(" ");
        Integer maximo = arbol.getMaxElem(arbol);
        System.out.println("El mayor elemento del arbol es: " + maximo);

        System.out.println(" ");
        Integer alto = arbol.getHeight();
        System.out.println("El alto del arbol es: " + alto);

        System.out.println();
        Integer valorAInsertar = 14;
        System.out.println("Insertando valor: " + valorAInsertar);
        arbol.insert(valorAInsertar);
        System.out.println("Arbol PreOrder:");
        arbol.printPreOrder();

        System.out.println();
        System.out.println("Rama más larga: " + arbol.getLongestBranch());

        System.out.println();
        Integer nivel = 2;
        System.out.println("Los elementos del nivel: " + nivel + " son: " + arbol.getElementAtLevel(nivel));

        System.out.println();
        Integer number = 10;
        System.out.println("Quiero borrar el valor: " + number);
        System.out.println("Se pudo?? --> " + arbol.delete(number));
        System.out.println("Arbol con el elemento borrado:");
        System.out.println("Arbol PreOrder:");
        arbol.printPreOrder();
    }

}
