package IteratorDesignPattern;

public class LinkedList implements Iterable<Integer>{
    public int data;
    public LinkedList next;
    public LinkedList(int value) {
        data = value;
        next = null;
    }

    public Iterator<Integer> getIterator() {
        return new LinkedListIterator(this);
    }
}
