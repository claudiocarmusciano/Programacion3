package ejer9;


import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	
	// la complejidad computacional de un array para insertar al principio   es O(1) 
	// la complejidad computacional de una lista dinámica para insertar al principio  es O(1)	
	
	public void insertFront(T o) {
		Node<T> tmp = new Node<T>(o,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size ++;
	}
	
	
	//Inserta un nodo al fin de la lista, es de complejidad O(n) porque porque, en el peor de los casos, 
	//tiene que recorrer toda la lista para insertarlo.
	
	public void insertLast( T info) {
		
		Node <T> ultimo = this.first;// insertar a derecha guardar el último....
		Node <T> nuevo = new Node <T>(info,null);
		if (this.isEmpty()) {
			this.first = nuevo;
		} else {
			while (ultimo.getNext()!= null) {
				ultimo = ultimo.getNext();
			}
			ultimo.setNext(nuevo);			
		}
		size++;
	}	
	
	
	//Retorna la info del primer nodo y lo elimina de la lista, es de complejidad O(1) porque solo realiza 1 acceso a memoria para obtener la info y eliminar el nodo.
	
	public T extractFront() {	
		if(this.first != null) {
			Node<T> tmp = this.first;
			this.first =  first.getNext();
			tmp.setNext(null);
			this.size --;
			return tmp.getInfo();
		}
		return null;
		
	}
	
	
	//Retorna si la lista está vacía o no, es de complejidad O(1) porque solo realiza 1 acceso a memoria
	
	public boolean isEmpty() {		
		return first == null;
	}
	
	
    // Retorna el contenido de un elemento, es de complejidad O(n) porque, en el peor de los casos, 
	//tiene que recorrer toda la lista para obtener la info.
	
	public T get(int index) {
		if(!this.isEmpty() && index >= 0 && index<this.size) {
			Node<T> next = this.first;
			int i = 0;
			while(i < index) {
				next = next.getNext();
				i++;
			}				
			return next.getInfo();			
		}
		return null;
	}
	
	
	// Retorna el contenido del primer elemento, es de complejidad O(1) porque sòlo realiza 1 acceso a memoria para obtener la info.
	
	public  T  getFirstElem() {
		Node<T> tmp = (Node<T>) this.first;		
	   return tmp.getInfo();
	}
	
	
	// Retorna el tamaño de la lista y es de complejidad O(1) porque en el peor de los casos sólo tiene que acceder al valor de la variable size.
	
	public int size() {	
		return this.size;
	}
	
	
	// Imprime la lista, es de complejidad O(n) porque, tiene que recorrer toda la lista para obtener la info.
	
	@Override
	public String toString() {
		String salida = "Contenido de la lista: \n";
		if (this.isEmpty()) {
			salida = "La lista se encuentra vacía";
		}else {
			Node<T> tmp = this.first;
			while (tmp != null) {
				salida +=" "+tmp.getInfo();
				tmp = tmp.getNext();
			}
		}
		return salida;
	}
	
	
	// tp1 Ejercicio 4 ( devuelve la posiciòn del elemento o -1 si no se encuentra )
	//	es de complejidad O(n) porque, en el peor de los casos, tiene que recorrer toda la lista para obtener la info.
	
	public int indexOf ( T info ) {
		Node<T> tmp = this.first;
		int indice = 0;
			if(!isEmpty()) {
				while(tmp != null && !tmp.getInfo().equals(info)) {					
					tmp = tmp.getNext();
					indice++;
				}
				if(tmp==null) {
					return -1;
				}
				else return indice;
			}
			else return -1;
	}


	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}
	

}
