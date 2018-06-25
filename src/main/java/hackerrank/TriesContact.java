package hackerrank;

import java.util.HashMap;
import java.util.Scanner;


/*
Basically we just need to implement a Tries in this problem
One tip is to store number of children at each node
Then we just have to go through the Characters, and stop at the end, figure out how many children that node has
 */

public class TriesContact {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Trie trie = new Trie();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");
            String op = opContact[0];
            String contact = opContact[1];

            if (op.equals("add")) {
                //add to tries
                trie.add(contact);
            } else if (op.equals("find")) {
                //find contact
                int numberofChildren = trie.find(contact);
                System.out.println(numberofChildren);
            }
        }

        scanner.close();
    }
}

class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public int size;

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    Trie(){} // default constructor

    public void add(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;

        /* Traverse down tree to end of our prefix */
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}
