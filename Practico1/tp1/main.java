package tp1;

import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

        lista.insertFront(40);
        lista.insertFront(12);
        lista.insertFront(30);
        lista.insertFront(32);
        lista.insertFront(35);

        // Esto hacía O(n*n)
        System.out.println("Mi lista: ");
        System.out.println("Con doble for:");
        for (int i=0; i<lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        // Así hace O(n)
        System.out.println("Con cursor:");
        lista.iniciarCursor();
        for (int i=0; i<lista.size(); i++) {
            System.out.println(lista.obtenerInfoCursor());
            lista.avanzarCursor();
        }

        System.out.println("---------------------");

        // Con Iterador:
        System.out.println("Con iterador:");

        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        // EJERCICIO 6.a

        //Elementos iguales de listas desordenadas
        System.out.println("---------------------");
        
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listaResultado = new MySimpleLinkedList<Integer>();
        
        //cargo lista 1
        lista1.insertFront(40);
        lista1.insertFront(12);
        lista1.insertFront(30);
        lista1.insertFront(32);
        lista1.insertFront(35);
        lista1.insertFront(10);
        lista1.insertFront(2);
        lista1.insertFront(5);

        //cargo lista 2
        lista2.insertFront(321);
        lista2.insertFront(10);
        lista2.insertFront(40);
        lista2.insertFront(2);
        lista2.insertFront(32);
        lista2.insertFront(120);
        lista2.insertFront(21);
        lista2.insertFront(5);

        System.out.println("Lista 1");
        System.out.println(lista1);
        System.out.println("Lista 2");
        System.out.println(lista2);
        System.out.println("Lista resultante:");

        listaResultado = listaResultado.searchDeuceElements(lista1, lista2);
        System.out.println(listaResultado);

        System.out.println();
        System.out.println();

        // EJERCICIO 6.b

        MySimpleLinkedList<Integer> listaO1 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listaO2 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listaResultadoO = new MySimpleLinkedList<Integer>();
        //cargo lista 1
        listaO1.insertFront(1500);
        listaO1.insertFront(500);
        listaO1.insertFront(100);
        listaO1.insertFront(8);
        listaO1.insertFront(7);
        listaO1.insertFront(6);
        listaO1.insertFront(5);
        listaO1.insertFront(3);
        

        //cargo lista 2
        listaO2.insertFront(8);
        listaO2.insertFront(7);
        listaO2.insertFront(6);
        listaO2.insertFront(5);
        listaO2.insertFront(4);
        listaO2.insertFront(3);
        listaO2.insertFront(2);
        listaO2.insertFront(1);

        System.out.println("Lista 1");
        System.out.println(listaO1);
        System.out.println("Lista 2");
        System.out.println(listaO2);
        System.out.println("Lista resultante:");

        listaResultadoO = listaResultadoO.ListInOrderListsOrderer(listaO1, listaO2);
        System.out.println(listaResultadoO);

        System.out.println();

        
        // EJERCICIO 7
        
        MySimpleLinkedList<Integer> lista01 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista02 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listaResult = new MySimpleLinkedList<Integer>();
        //cargo lista 1
        lista01.insertFront(1500);
        lista01.insertFront(500);
        lista01.insertFront(100);
        lista01.insertFront(8);
        lista01.insertFront(7);
        lista01.insertFront(6);
        lista01.insertFront(5);
        lista01.insertFront(3);
        

        //cargo lista 2
        lista02.insertFront(8);
        lista02.insertFront(7);
        lista02.insertFront(6);
        lista02.insertFront(5);
        lista02.insertFront(4);
        lista02.insertFront(3);
        lista02.insertFront(2);
        lista02.insertFront(1);

        System.out.println("Lista 1");
        System.out.println(lista01);
        System.out.println("Lista 2");
        System.out.println(lista02);
        System.out.println("Lista resultante:");

        listaResult = listaResult.ListaUnoMenosDos(lista01, lista02);
        System.out.println(listaResult);

        System.out.println();
        // System.out.println("Tamaño: " + lista.size());

        // System.out.println("Está vacía? : " + lista.isEmpty());

        // System.out.println("get (3): " + lista.get(3));

        // MySimpleStack<Integer> pila = new MySimpleStack<Integer>();
        // pila.push(12);
        // pila.push(13);
        // pila.push(89);
        // pila.push(65);
        // pila.push(72);

        // System.out.println("Mi pila: ");
        // System.out.println(pila);

        // pila.pop();

        // System.out.println("Mi pila: ");
        // System.out.println(pila);

        // System.out.println("Info del primer elemento: " + pila.top());

        // // MySimpleStack<Integer> newPila = pila;
        // // newPila.reverse(pila);

        // System.out.println("Pila inversa: ");
        // pila.reverse();
        // System.out.println(pila);
        
        // System.out.println("Busco el valor 400 en la fila...");
        // System.out.println("Está en la posición: " + lista.indexOf(400));
    }
}
