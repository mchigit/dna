package dataStructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
Uni directional graph
This solution was taken from CTCI Graph implementation
https://www.youtube.com/watch?v=zaBhtODEL0w
 */

public class Graph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        private Node(int id) {
         this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        sourceNode.adjacent.add(destinationNode);
    }

    public boolean hasPathDFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if (visited.contains(s.id)) return false;
        visited.add(s.id);
        if (s == d) return true;
        for (Node child : s.adjacent) {
            if (hasPathDFS(child, d, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int s, int d) {
        Node source = getNode(s);
        Node destination = getNode(d);
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.getFirst();
            if (node == destination) {
                return true;
            }

            if (!visited.contains(node.id)) {
                visited.add(node.id);
            }

            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
