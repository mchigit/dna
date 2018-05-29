package dataStructures.stackQueues;

import java.util.LinkedList;

public class Queue {
    private int queueSize;
    private LinkedList<Integer> queue;

    public Queue() {
        queueSize = 0;
        queue = new LinkedList<Integer>();
    }

    public void enqueue(int data) {
        queue.addLast(data);
        queueSize++;
    }

    public int dequeue() {
        queueSize--;
        return queue.removeFirst();
    }

    public int nextElement() {
        return queue.getFirst();
    }

    public int getQueueSize() {
        return queueSize;
    }
}
