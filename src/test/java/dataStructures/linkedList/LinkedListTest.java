package dataStructures.linkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinkedListTest {
    private LinkedList list;
    private int[] data = new int[10];

    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
            list.appendToTail(i);
        }
    }

    @org.junit.Test
    public void getSize() {
        assertTrue(list.getSize() == 10);
    }

    @Test
    public void getHead() {
        Node headNode = list.getHead();
        assertTrue(headNode.getData() == 0);
    }

    @Test
    public void getTail() {
        assertTrue(list.getTail().getData() == 9);
    }

    @Test
    public void insertAtTail() {
        list.appendToTail(100);
        assertTrue(list.getTail().getData() == 100);
    }

    @Test
    public void insertAtHead() {
        list.addToHead(100);
        assertTrue(list.getHead().getData() == 100);
    }



}
