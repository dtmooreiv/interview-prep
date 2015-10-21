package me.treymoore.interview.lists;

public class SortedCircularlyLinkedList<T extends Comparable> {

    private Node<T> head;

    public SortedCircularlyLinkedList(T value) {
        this.head = new Node<T>(value);
        head.setNext(head);
    }

    public Node<T> insertValue(T value) {
        Node<T> cur = head;
        Node<T> next = cur.getNext();

        Node<T> newNode = new Node<T>(value);

        boolean inserted = false;

        while(!inserted) {

            //If the new value goes between cur and next
            if(value.compareTo(cur.getValue()) > 0 && value.compareTo(next.getValue()) <= 0) {
                cur.setNext(newNode);
                newNode.setNext(next);
                inserted = true;
            }
            //If the new value is the same as next
            else if(value.compareTo(next.getValue()) == 0) {
                cur.setNext(newNode);
                newNode.setNext(next);
                inserted = true;
            }
            //If we've reached the end of the list
            else if(cur.getValue().compareTo(next.getValue()) > 0 || cur == next) {
                //We need to check if the value belongs at the end of the list, or at the beginning
                if((value.compareTo(cur.getValue()) >= 0 || value.compareTo(next.getValue()) <= 0)) {
                    cur.setNext(newNode);
                    newNode.setNext(next);
                    inserted = true;
                } else {
                    cur = next;
                    next = cur.getNext();
                }
            } else {
                cur = next;
                next = cur.getNext();
            }
        }

        return newNode;
    }

    //Removes the first
    public boolean removeNode(T value) {
        Node<T> cur = head;
        Node<T> next = cur.getNext();

        boolean looped = false;

        while(!looped) {
            if(next.getValue().equals(value)) {
                if(head.getValue().equals(value)) {
                    head = head.getNext();
                }
                cur.setNext(next.getNext());
                return true;
            } else if(next == head) {
                looped = true;
            }
            cur = next;
            next = cur.getNext();
        }

        return false;
    }

    public int size() {
        Node<T> cur = head;
        Node<T> next = cur.getNext();
        int count = 0;
        boolean looped = false;

        while(!looped) {
            count++;
            if(next == head) {
                looped = true;
            } else {
                cur = next;
                next = cur.getNext();
            }
        }

        return count;
    }

    public void printList(){
        System.out.println("Printing list");
        Node<T> cur = head;
        boolean looped = false;
        System.out.print("{");
        while(!looped) {
            System.out.print(cur.getValue().toString());

            if(cur.getNext() == head) {
                looped = true;
            } else {
                System.out.print(", ");
            }

            cur = cur.getNext();
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        SortedCircularlyLinkedList<Integer> list = new SortedCircularlyLinkedList<Integer>(5);
        list.insertValue(7);
        list.insertValue(2);
        list.insertValue(6);
        list.insertValue(0);
        list.insertValue(105);
        list.insertValue(45);
        list.insertValue(34);
        list.insertValue(-204);
        list.insertValue(-204);
        list.insertValue(1);
        list.printList();

        System.out.println("Length of list: " + list.size());

        list.removeNode(34);
        list.removeNode(5);
        list.removeNode(0);
        list.removeNode(-204);
        list.removeNode(999);
        list.printList();
    }
}
