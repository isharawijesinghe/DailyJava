package top75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CloneGraph {

    HashMap<Node, Node> mappedHashMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (mappedHashMap.containsKey(node)){
            return mappedHashMap.get(node);
        }

        Node newNode = new Node(node.val);
        mappedHashMap.put(node, newNode);
        for (Node n: node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}