package dataStructures.stackQueues;

//We will implement Stack using LinkedList instead of Array

import java.util.LinkedList;

public class Stack {
    private int stackSize;
    private LinkedList<Integer> stack;

    public Stack() {
        stackSize = 0;
        stack = new LinkedList<Integer>();
    }

    public void push(int data) {
        stack.addLast(data);
        stackSize ++;
    }

    public int top() {
        return stack.getLast();
    }

    public int pop() {
        stackSize--;
        return stack.removeLast();
    }

    public int getSize() {
        return stackSize;
    }
}
