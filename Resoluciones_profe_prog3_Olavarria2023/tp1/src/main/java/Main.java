import java.util.Iterator;

public class Main {
    public static <T> MySimpleLinkedList<Integer> Ejercicio6_a_listaResultante(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        MySimpleLinkedList<Integer> listaFinal = new  MySimpleLinkedList<Integer>();
        Iterator<T> it1 = l1.iterator();
        while(it1.hasNext()) {
            Integer valor1 = (Integer) it1.next();
            Iterator<T> it2 = l2.iterator();
            while(it2.hasNext()) {
                Integer valor2 = (Integer) it2.next();
                if(valor1 == valor2) {
                    Iterator<Integer> it3 = listaFinal.iterator();
                    if(it3.hasNext()) {
                        if(valor1<(Integer) listaFinal.get(0)) {
                            listaFinal.insertFront((Integer) valor1);
                        }
                        else {
                            listaFinal.insertLast((Integer) valor1);
                        }
                    }
                    else {
                        listaFinal.insertFront((Integer) valor1);
                    }
                }
            }
        }
        return listaFinal;
    }

    public static <T> MySimpleLinkedList<Integer> Ejercicio6_b_listaResultante(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        MySimpleLinkedList<Integer> listaFinal = new  MySimpleLinkedList<Integer>();
        Iterator <T> it1 = l1.iterator();
        Iterator <T> it2 =  l2.iterator();
        Integer valor1 = (Integer) it1.next();
        Integer valor2 = (Integer) it2.next();
        while(it1.hasNext() && it2.hasNext()) {
            if(valor1<valor2) {
                valor1 = (Integer) it1.next();
                while(valor1 < valor2 ) {
                    valor1 = (Integer) it1.next();
                    if(valor1 == valor2) {
                        listaFinal.insertLast(valor1);
                        valor1=(Integer) it1.next();
                        valor2 = (Integer) it2.next();
                    }
                }
            }
            if(valor1>valor2) {
                while(valor2 < valor1 ) {
                    valor2 = (Integer) it2.next();
                    if(valor1 == valor2) {
                        listaFinal.insertLast(valor1);
                        if(it1.hasNext() && it2.hasNext()) {
                            valor1=(Integer) it1.next();
                            valor2 = (Integer) it2.next();
                        }
                    }
                }
            }
            if(valor1==valor2) {
                listaFinal.insertLast(valor1);
                if(it1.hasNext() && it2.hasNext()) {
                    valor1=(Integer) it1.next();
                    valor2 = (Integer) it2.next();
                }
            }
        }

        return listaFinal;
    }

    public static <T> MySimpleLinkedList<Integer> Ejercicio7_listaResultante(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        MySimpleLinkedList<Integer> listaFinal = new  MySimpleLinkedList<Integer>();
        Iterator<T> it1 = l1.iterator();

        while(it1.hasNext()) {
            Integer aux=null;
            Integer valor1 = (Integer) it1.next();
            Iterator<T> it2 = l2.iterator();
            while(it2.hasNext()) {
                Integer valor2 = (Integer) it2.next();
                if(valor1 == valor2) {
                    aux=valor1;
                }
            }
            if(aux==null) {
                listaFinal.insertFront(valor1);
            }
        }
        return listaFinal;
    }



    public static void main(final String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
//		lista1.insertFront(6);
//		lista1.insertFront(3);
//		lista1.insertFront(12);
//		lista1.insertFront(1);
//		lista1.insertFront(8);
//		lista1.insertFront(7);
//		lista1.insertLast(99);
//		lista1.insertLast(88);
//		///////////////////////
//		lista2.insertFront(5);
//		lista2.insertFront(1);
//		lista2.insertFront(9);
//		lista2.insertFront(12);
//		lista2.insertFront(7);
//		lista2.insertLast(77);
//		lista2.insertLast(88);
//		System.out.println("   Lista resultante de lista1 y lista2 ejercicio 6_a TP1   ");
//		System.out.println( Ejercicio6_a_listaResultante(lista1,lista2));
//		System.out.println("--------------------------");

        lista1.insertFront(12);
        lista1.insertFront(11);
        lista1.insertFront(9);
        lista1.insertFront(8);
        lista1.insertFront(3);
        lista1.insertFront(1);
        lista1.insertLast(50);
        lista1.insertLast(88);
        lista2.insertLast(50);
        lista2.insertFront(24);
        lista2.insertFront(12);
        lista2.insertFront(9);
        lista2.insertFront(8);
        lista2.insertFront(5);
        lista2.insertLast(88);
        lista2.insertLast(89);
        System.out.println("   lista 1   ");
        System.out.println(lista1);
        System.out.println("--------------------------");
        System.out.println("   lista 2   ");
        System.out.println(lista2);
        System.out.println("--------------------------");
//        System.out.println("   Lista resultante de lista_1 y lista_2 ejercicio 6_b TP1   ");
//        System.out.println( Ejercicio6_b_listaResultante(lista1,lista2));
//        System.out.println("--------------------------");
//        System.out.println("   Lista resultante de lista_1 y lista_2 ejercicio 7 TP1   ");
//        System.out.println(Ejercicio7_listaResultante(lista1,lista2));
    }


}
