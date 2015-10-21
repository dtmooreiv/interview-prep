package me.treymoore.interview.lists;

public class DoubleNode<T> extends Node<T> {
    private Node<T> prev;

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public DoubleNode(T val) {
        super(val);
    }
}
