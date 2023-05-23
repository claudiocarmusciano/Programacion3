import java.util.Iterator;

public class IteratorAdyacentes<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> iterador;

    public IteratorAdyacentes(Iterator<Arco<T>> iterador) {
        this.iterador = iterador;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Integer next() {
        Arco<T> arco = iterador.next();
        return arco.getVerticeDestino();
    }

}
