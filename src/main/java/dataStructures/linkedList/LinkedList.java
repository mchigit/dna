package dataStructures.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void appendToTail(int d) {
        Node newTail = new Node(d);
        size++;
        if (head == null) {
            //inserting first element
            head = newTail;
            tail = head;
        } else {
            //inserting at the end
            tail.setNext(newTail);
            tail = newTail;
        }
    }

    public void addToHead(int d) {
        Node temp = new Node(d);
        size++;
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            temp.setNext(head);
            head = temp;
        }
    }

    public int removeLast() {
        //as this is a singly linked list, we have to loop until the tail
        if (size == 0) {
            throw new RuntimeException("Tried to remove from empty linked list");
        }

        if (size == 1) {
            int data = tail.getData();
            head = null;
            tail = null;
            return data;
        }

        int removedData = tail.getData();
        size--;
        Node temp = head;
        while (temp.getNext() != null && temp.getNext() != tail) {
            temp = temp.getNext();
        }

        temp.setNext(null);
        tail = temp;
        return removedData;
    }
}
