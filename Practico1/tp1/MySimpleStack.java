package tp1;

public class MySimpleStack<T> {
    private MySimpleLinkedList<T> stack;

    public MySimpleStack() {
        this.stack = new MySimpleLinkedList<T>();
    }

    public void push(T data) {
        stack.insertFront(data);
    }

    public T pop() {
        if (stack.first != null) {
            T data = stack.first.getInfo();
            stack.first = stack.first.getNext();
            return data;
        } else {
            return null;
        }
    }

    public T top() {
        return stack.get(0);
    }

    public void reverse() {
        MySimpleLinkedList<T> inverseStack = new MySimpleLinkedList<T>();
        while (!stack.isEmpty()) {
            T value = stack.extractFront();
            inverseStack.insertFront(value);
        }
        stack = inverseStack;
    }

    
    

    @Override
    public String toString() {
        String numbers = "";
        if (!stack.isEmpty()) {
            Node<T> temp = stack.first;
            while (temp != null) {
                numbers = numbers + (temp.getInfo()) + " " + '\n';
                temp = temp.getNext();
            }
        }
        return numbers;
    }
}
