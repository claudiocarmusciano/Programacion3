package ejer8;

import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T> {
	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public MyDoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	
	public void insertFront(T info) {
		if (this.first == null) {
			this.first = new Node<T>(info,null,null);
			this.last = this.first;
		}
		else {
			Node<T> nuevo = new Node<T>(info,null,this.first);
			this.first.setPrev(nuevo);
			this.first = nuevo;
		}
		
		this.size ++;
	}
	
	public void insertLast(T info) {
		
		Node <T> nuevo = new Node <T>(info,this.last,null);
		if (this.isEmpty()) {
			this.insertFront(info);
		} else {
			this.last.setNext(nuevo);
			nuevo.setPrev(this.last);					
			this.last = nuevo;
		}
			
		size++;
	}
	
	public T extractFront() {	
		Node<T> tmp = this.first;
		this.first = this.first.getNext();
		if(this.first != null) {			
			this.first.setPrev(null);
			this.size --;
			return tmp.getInfo();
		}
		return null;
		
	}
	
	public T extractLast() {	
		Node<T> tmp = this.last;
		this.last = this.last.getPrev();
		if(this.last != null) {			
			this.last.setNext(null);
			this.size --;
			return tmp.getInfo();
		}
		return null;
		
	}

	private boolean isEmpty() {
		return first == null;
	}
	
	public T readLast() {
		return last.getInfo();
	}
	
	public T get(int index) {
	return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
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
}
