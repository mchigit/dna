package hackerrank;

public class BinaryTreeCheck {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        return isBST(root.left, minValue, maxValue);
    }

    boolean isBST(Node root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.data < minValue || root.data > maxValue) {
            return false;
        }

        return isBST(root.left, minValue, root.data) && isBST(root.right, root.data + 1, maxValue);
    }
}
