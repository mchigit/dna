package hackerrank;

public class DetectCycleLinkedList {

    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
*/

    class Node {
        int data;
        Node next;
    }


    boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;
        Node faster = head.next;
        Node slower = head;
        while (slower.next != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }
}
