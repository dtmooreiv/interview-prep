package me.treymoore.interview.lists;

public class DoublyLinkedListImpl<T> {

    private DoubleNode<T> head;

    public DoubleNode<T> getHead() {
        return this.head;
    }

    public void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    public DoublyLinkedListImpl(T value) {
        this.head = new DoubleNode<T>(value);
    }

    //Add to the front of the list;
    public void add(T value) {
        DoubleNode<T> newNode = new DoubleNode<T>(value);

    }
}
