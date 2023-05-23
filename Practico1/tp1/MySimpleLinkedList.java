package tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

	Node<T> first;
	private int sizeList;
	private Node<T> cursor;

	public MySimpleLinkedList() {
		this.first = null;
		this.sizeList = 0;
		this.cursor = null;

	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.sizeList++;

	}

	public T extractFront() {
		if (this.first != null) {
			T info = this.get(0);
			this.first = this.first.getNext();
			this.sizeList--;
			return info;
		} else {
			return null;
		}

	}

	public boolean isEmpty() {
		return (this.first == null);
	}

	public T get(int index) {
		if (( -1 < index ) && ( index < sizeList)) {
			int indice = 0;
			Node<T> cursor = this.first;
			while ((cursor != null) && (indice != index)) {
				indice++;
				cursor = cursor.getNext();
			}
			return cursor.getInfo();
		} else {
			return null;
		}
			
	}

	public int size() {
		return this.sizeList;
	}

	public int indexOf (T value) {
		Node<T> cursor = this.first;
		int index = 0;
		int tope = this.size()-1;
		while (cursor.getInfo() != value && index<tope) {
			cursor = cursor.getNext();
			index++;
		}

		if (cursor.getInfo() == value) {
			return index;
		} else {
			return -1;
		}
	}

	public void iniciarCursor() {
		this.cursor = this.first;
	}

	public void avanzarCursor() {
		this.cursor = this.cursor.getNext(); 
	}

	public T obtenerInfoCursor() {
		return this.cursor.getInfo();
	} 

	public void insertInOrder(T valor) {
		Node<T> cursor = new Node<T> (valor, null);
		if (isEmpty() || first.getInfo().compareTo(valor) > 0) {
			cursor.setNext(first);
			first = cursor;
		} else {
			Node<T> tmp = first;
			while (tmp.getNext()!=null && tmp.getNext().getInfo().compareTo(valor)<=0) {
				tmp=tmp.getNext();
			}
			cursor.setNext((tmp.getNext()));
			tmp.setNext(cursor);
		}
		sizeList++;
	}

	public MySimpleLinkedList<Integer> searchDeuceElements (MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2) {
		MySimpleLinkedList<Integer> nuevaLista = new MySimpleLinkedList<Integer>();
		Iterator<Integer> it1 = lista1.iterator();
		Iterator<Integer> it2 = lista2.iterator();

        while (it1.hasNext()) {
			Integer num1 = it1.next();
			while (it2.hasNext()) {
				Integer num2 = it2.next();
				if (num1 == num2) {
					nuevaLista.insertInOrder(num2);
				}
			}
			it2 = lista2.iterator();
		}	
		return nuevaLista;
	}

	public MySimpleLinkedList<Integer> ListInOrderListsOrderer (MySimpleLinkedList<Integer> listaO1, MySimpleLinkedList<Integer> listaO2) {
		
		MySimpleLinkedList<Integer> nuevaLista = new MySimpleLinkedList<Integer>();
		MyIterator<Integer> it1 = (MyIterator<Integer>) listaO1.iterator();
		MyIterator<Integer> it2 = (MyIterator<Integer>) listaO2.iterator();

		while ((it1.hasNext()) && (it2.hasNext())) {
			if(it1.valor() == it2.valor()) {
				nuevaLista.insertInOrder(it2.valor());
				it1.next();
				it2.next();
			} 
			else if (it1.valor() > it2.valor()) it2.next();
			else it1.next();
			
		}
		return nuevaLista;
	}

	public MySimpleLinkedList<Integer> ListaUnoMenosDos (MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2) {
		MySimpleLinkedList<Integer> nuevaLista = new MySimpleLinkedList<Integer>();
		Iterator<Integer> it1 = (MyIterator<Integer>) lista1.iterator();
		Iterator<Integer> it2 = (MyIterator<Integer>) lista2.iterator();

		while (it1.hasNext()) {
			Integer num1 = it1.next();
			if (!lista2.contains(num1)) {
				nuevaLista.insertFront(num1);
			}
		}	
		return nuevaLista;
	}

	@Override
	public String toString() {
		String numbers = "";
		if (!isEmpty()) {
			;
			Node<T> temp = this.first;
			while (temp != null) {
				numbers = numbers + (temp.getInfo()) + " ";
				temp = temp.getNext();
			}
		}
		return numbers;
	}



	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(first);
	}

	public boolean contains(T ele) {
        for (T element : this) {
            if (element.equals(ele)) {
                return true;
            }
        }
        return false;
    }

}
