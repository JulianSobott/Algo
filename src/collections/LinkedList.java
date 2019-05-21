package collections;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> next, E item, Node<E> prev){
            this.next = next;
            this.item = item;
            this.prev = prev;
        }
    }

    public E search(){
        return null;
    }

    public void add(E item){
        Node<E> n = new LinkedList.Node<>(null, item, this.first);
        if(this.first != null){
            this.first.prev = n;
        }
        this.first = n;
    }


}
