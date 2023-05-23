package tp1.Ejercicio8;

public class DoubleNode<T> {

	private T info;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;

	// insert front
	// insert alst
	// eliminar adelante
	// eliminar atras

	public DoubleNode() {
		this.info = null;
		this.next = null;
		this.prev = null;
	}

	public DoubleNode(T info, DoubleNode<T> next, DoubleNode<T> prev) {
		this.setInfo(info);
		this.setNext(next);
		this.setPrev(prev);
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public DoubleNode<T> getPrev() {
		return prev;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public void setPrev(DoubleNode<T> prev) {
		this.prev = prev;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

}
