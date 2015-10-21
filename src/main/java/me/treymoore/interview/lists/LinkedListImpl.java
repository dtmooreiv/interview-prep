package me.treymoore.interview.lists;

public class LinkedListImpl<T> {
    public LinkedListImpl(Node<T> head) {
        this.head = head;
    }

    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    //Convenience method
    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        add(newNode);
    }

    //Adds a new node to the start of the list
    public void add(Node<T> node) {
        node.setNext(head);
        this.head = node;
    }

    public void addEnd(T value) {
        Node<T> newNode = new Node<T>(value);
        addEnd(newNode);
    }

    //Adds a new node to the end of the list
    public void addEnd(Node<T> node) {
        Node<T> cur = head;
        while(cur.getNext() != null) {
            cur = cur.getNext();
        }

        cur.setNext(node);
    }

    //Such convenience, many tedium
    public void insert(T value, int index) {
        Node<T> newNode = new Node<T>(value);
        insert(newNode, index);
    }

    //Inserts node at the given index
    //This version will
    public void insert(Node<T> node, int index) {
        Node<T> cur = head;
        int curInd = 0;
        while(cur.getNext() != null && curInd < index - 1) {
            cur = cur.getNext();
            curInd++;
        }

        if(curInd == index - 1) {
            Node<T> next = cur.getNext();
            cur.setNext(node);
            node.setNext(next);
        }
    }

    //Returns the size of the list
    public int size() {
        Node cur = head;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.getNext();
        }

        return size;
    }

    //Gets the node at the index value
    public Node<T> get(int index) {
        int curInd = 0;
        Node<T> cur = head;
        if(index < 0) {
            throw new IndexOutOfBoundsException("Given index: " + index + " out of bounds.");
        }
        while(curInd < index && cur != null) {
            curInd++;
            cur = cur.getNext();
        }

        if(curInd == index) {
            return cur;
        } else {
            throw new IndexOutOfBoundsException("Given index: " + index + " out of bounds");
        }
    }

    public boolean delete(T value) {
        Node<T> cur = head;
        Node<T> prev = null;

        while(cur != null) {
            if(cur.getValue().equals(value)) {
                if(prev != null) {
                    prev.setNext(cur.getNext());
                } else {
                    head = head.getNext();
                }
            } else {
                prev = cur;
                cur = cur.getNext();
            }
        }

        return false;
    }

    //Removes node from this list if its contained
    //Returns true if the node was deleted.
    public boolean delete(Node<T> node) {
        Node<T> cur = head;
        Node<T> prev = null;

        while(cur != null) {
            if(cur == node) {
                if(prev != null) {
                    prev.setNext(cur.getNext());
                } else {
                    head = head.getNext();
                }
                return true;
            } else {
                prev = cur;
                cur = cur.getNext();
            }
        }

        return false;
    }

    //Makes a list of (Frank, Joe, Misty, Penny, Coby)
    public static LinkedListImpl<String> getLinkedList() {
        Node<String> head = new Node<String>("Coby");
        LinkedListImpl<String> list = new LinkedListImpl<String>(head);

        list.add(new Node<String>("Penny"));
        list.add(new Node<String>("Misty"));
        list.add(new Node<String>("Joe"));
        list.add(new Node<String>("Frank"));

        return list;
    }

    public static void main(String[] args) {
        LinkedListImpl<String> list = getLinkedList();
        System.out.println(list.size());
        //Printing unmodified linkedList
        printLinkedList(list);

        LinkedListImpl<String> list2 = getLinkedList();
        list2.addEnd(new Node<String>("Terrence"));
        //Printing list with Terrence added to the end
        System.out.println("Modified list");
        printLinkedList(list2);

        System.out.println("Deleted value from list");
        list2.delete(list2.getHead());
        printLinkedList(list2);

        int index = 2;
        System.out.println("Node at index: " + index + " is " + list2.get(index));

        Node<String> newNode = new Node<String>("Tao");
        list2.insert(newNode, index);
        System.out.println("Inserted new node at index: " + index);
        printLinkedList(list2);
    }

    public static void printLinkedList(LinkedListImpl list) {
        Node cur = list.getHead();
        while(cur != null) {
            System.out.println(cur.toString());
            cur = cur.getNext();
        }
    }
}
