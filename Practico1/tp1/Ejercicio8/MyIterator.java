package tp1.Ejercicio8;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private DoubleNode<T> cursor;

    public MyIterator(DoubleNode<T> first) {
        this.cursor = first;
    }

    public T valor() {
        return this.cursor.getInfo();
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }
}
