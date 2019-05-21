package collections;

import java.util.EmptyStackException;

public class Stack<E> {

    private static final int INITIAL_SIZE = 10;

    private Object[] items;

    private int top = 0;

    public Stack(){
        this.items = new Object[Stack.INITIAL_SIZE];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void push(E item){
        this.top++;
        if(this.top >= this.items.length){
            this.grow();
        }
        this.items[this.top] = item;
    }

    @SuppressWarnings("unchecked")
    public E pop() throws EmptyStackException{
        if(this.isEmpty()) throw new EmptyStackException();
        this.top--;
        E e = (E) this.items[this.top + 1];
        this.items[this.top + 1] = null;
        return e;
    }

    private void grow() {
        Object[] a = new Object[this.items.length + 10];
        System.arraycopy(this.items, 0, a, 0, this.items.length);
        this.items = a;
    }
}
