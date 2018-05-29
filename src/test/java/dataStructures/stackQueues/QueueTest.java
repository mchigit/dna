package dataStructures.stackQueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue();
    }

    @Test
    public void enqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertTrue(queue.getQueueSize() == 3);
        assertTrue(queue.nextElement() == 1);
    }

    @Test
    public void dequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertTrue(queue.dequeue() == 1);
        assertTrue(queue.dequeue() == 2);
        assertTrue(queue.dequeue() == 3);
        assertTrue(queue.getQueueSize() == 0);
    }

    @Test
    public void getQueueSize() {
        assertTrue(queue.getQueueSize() == 0);
    }
}