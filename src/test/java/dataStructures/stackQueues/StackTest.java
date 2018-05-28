package dataStructures.stackQueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void push() {
        stack.push(0);
        stack.push(1);
        assertTrue(stack.top() == 1);
        assertTrue(stack.getSize() == 2);
    }

    @Test
    public void pop() {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.top() == 1);
        assertTrue(stack.getSize() == 2);
    }
}
