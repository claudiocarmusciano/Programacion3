import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private int size;
    private Node<T> last;
    public MySimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    // la complejidad computacional de un array para insertar al principio   es O(1)
    // la complejidad computacional de una lista dinï¿½mica para insertar al principio  es O(1)

//    public void insertFront(T o) {
//        Node<T> nuevo = new Node<T>(o,null);
//        this.last = this.first;
//        nuevo.setNext(this.first);
//        this.first = nuevo;
//        this.size ++;
//    }


    //Inserta un nodo al fin de la lista, es de complejidad O(n) porque porque, en el peor de los casos,
    //tiene que recorrer toda la lista para insertarlo.
    //Aunque se puede resolver de forma mucho más eficiente si se usa un atributo de clase Node<T> last
    // para saber todo el tiempo cuál es el último elemento sin tener que buscarlo cada vez.

//    public void insertLast( T info) {
//
//        Node <T> ultimo = this.first;// insertar a derecha guardar el último....
//        Node <T> nuevo = new Node <T>(info,null);
//        if (this.isEmpty()) {
//            this.first = nuevo;
//        } else {
//            while (ultimo.getNext()!= null) {
//                ultimo = ultimo.getNext();
//            }
//            ultimo.setNext(nuevo);
//        }
//        size++;
//    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Esta forma de insertLast es mas eficiente porque en
    // todo momento se cuál es el último nodo y no tengo que andar buscandolo cada vez
    public void insertLast( T info) {
        Node <T> nuevo = new Node <T>(info,null);
        if (this.isEmpty()) {
            nuevo.setNext(this.first);
            this.first = nuevo;
        }else{
            this.last.setNext(nuevo);
            this.last= nuevo;
            this.size++;
        }
    }

    public void insertFront(T o) {
        Node<T> nuevo = new Node<T>(o,null);
        if(this.last == null){
            this.last = this.first;
        }
        nuevo.setNext(this.first);
        this.first = nuevo;
        this.size ++;
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


    //Retorna si la lista estï¿½ vacï¿½a o no, es de complejidad O(1) porque solo realiza 1 acceso a memoria

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


    // Retorna el contenido del primer elemento, es de complejidad O(1) porque sï¿½lo realiza 1 acceso a memoria para obtener la info.

    public  T  getFirstElem() {
        Node<T> tmp = (Node<T>) this.first;
        return tmp.getInfo();
    }


    // Retorna el tamaï¿½o de la lista y es de complejidad O(1) porque en el peor de los casos sï¿½lo tiene que acceder al valor de la variable size.

    public int size() {
        return this.size;
    }


    // Imprime la lista, es de complejidad O(n) porque, tiene que recorrer toda la lista para obtener la info.

    @Override
    public String toString() {
        String salida = "Contenido de la lista: \n";
        if (this.isEmpty()) {
            salida = "La lista se encuentra vacï¿½a";
        }else {
            Node<T> tmp = this.first;
            while (tmp != null) {
                salida +=" "+tmp.getInfo();
                tmp = tmp.getNext();
            }
        }
        return salida;
    }


    // tp1 Ejercicio 4 ( devuelve la posiciï¿½n del elemento o -1 si no se encuentra )
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