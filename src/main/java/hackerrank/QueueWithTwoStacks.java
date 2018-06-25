package hackerrank;

import java.util.Scanner;
import java.util.Stack;


/*
To implement queue using 2 stacks, you always need to move elements around, it's gonna be either when enqueue, or dequeue
Notice moving elements when dequeue, you don't actually have to move elements back
So the solution is basically, always enqueue onto 1 stack (Stack1)
If a dequeue or peek, first look at the other stack (Stack2). If Stack2 is empty, then pop all elements from Stack1 and push to Stack2, therefore Stack2 will actually have the correct order.
Therefore if Stack2 is not empty, just directly return the first element. (Peek or pop)
 */
public class QueueWithTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            shiftQueue();

            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            shiftQueue();

            return stackOldestOnTop.pop();
        }

        private void shiftQueue() {
            if (stackOldestOnTop.empty()) {
                while (!stackNewestOnTop.empty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
