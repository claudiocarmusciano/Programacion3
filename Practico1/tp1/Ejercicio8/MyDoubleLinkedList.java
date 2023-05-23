package tp1.Ejercicio8;

import java.util.Iterator;

public class MyDoubleLinkedList <T extends Comparable<T>> implements Iterable<T> {
   
        private DoubleNode<T> first;
        private int sizeList;
        private DoubleNode<T> cursor;
    
        public MyDoubleLinkedList() {
            this.first = null;
            this.sizeList = 0;
            this.cursor = null;
    
        }
    
        public void insertFront(T info) {
            DoubleNode<T> tmp = new DoubleNode<T>(info, null, null);
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
                DoubleNode<T> cursor = this.first;
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
            DoubleNode<T> cursor = this.first;
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
            DoubleNode<T> cursor = new DoubleNode<T> (valor, null, null);
            if (isEmpty() || first.getInfo().compareTo(valor) > 0) {
                cursor.setNext(first);
                first = cursor;
            } else {
                DoubleNode<T> tmp = first;
                while (tmp.getNext()!=null && tmp.getNext().getInfo().compareTo(valor)<=0) {
                    tmp=tmp.getNext();
                }
                cursor.setNext((tmp.getNext()));
                tmp.setNext(cursor);
            }
            sizeList++;
        }
    
        
    
        @Override
        public String toString() {
            String numbers = "";
            if (!isEmpty()) {
                ;
                DoubleNode<T> temp = this.first;
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
