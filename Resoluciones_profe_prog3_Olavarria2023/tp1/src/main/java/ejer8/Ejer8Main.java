package ejer8;


public class Ejer8Main {

	public static void main(String[] args) {
		MyDoubleLinkedList<Integer> lista1 = new MyDoubleLinkedList<Integer>();
		MyDoubleLinkedList<Integer> lista2 = new MyDoubleLinkedList<Integer>();	
		
		lista1.insertFront(6);
		lista1.insertFront(3);
		lista1.insertFront(12);
		lista1.insertFront(1);
		lista1.insertFront(8);
		lista1.insertFront(7);		
		lista1.insertLast(99);
		lista1.insertLast(88);	
		lista2.insertFront(5);
		lista2.insertFront(1);
		lista2.insertFront(9);
		lista2.insertFront(12);
		lista2.insertFront(7);
		lista2.insertLast(77);
		lista2.insertLast(88);	
		System.out.println("   lista 1   ");
		System.out.println(lista1);
		System.out.println("--------------------------");
//		System.out.println("   lista 2   ");
//		System.out.println(lista2);
//		System.out.println("--------------------------");
		System.out.println("se extrajo el elemento");
		System.out.println(lista1.extractFront());
		System.out.println("--------------------------");
		System.out.println("se extrajo el elemento");
		System.out.println(lista1.extractFront());
		System.out.println("--------------------------");
		System.out.println("   lista 1 con extracciones   ");
		System.out.println(lista1);
		lista1.insertFront(45);
		System.out.println("--------------------------");
		System.out.println(lista1);
		System.out.println("--------------------------");
		System.out.println(lista1.extractLast());
		System.out.println(lista1);
		System.out.println(lista1.readLast());
		
	}

}
