package IteratorDesignPattern;

public class LinkedListIterator implements Iterator<Integer>{
    private LinkedList current;

    public LinkedListIterator(LinkedList head) {
        current = head;
    }

    public boolean hasNext() {
        return current.next != null;
    }

    public Integer current(){
        return current.data;
    }

    public void next() {
        current = current.next;
    }
}
