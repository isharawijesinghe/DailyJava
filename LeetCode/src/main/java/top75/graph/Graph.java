package top75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    HashMap<GraphNode, ArrayList<GraphNode>> adjList;

    Graph(List<GraphNode> list) {
        this.adjList = new HashMap<>();
        for(GraphNode n:list)
            adjList.put(n, new ArrayList<>());
    }

    public void addEdge(GraphNode graphNode1, GraphNode node2){
        adjList.get(graphNode1).add(node2);
        adjList.get(node2).add(graphNode1);
    }

}


class GraphNode {
    String nodeName;
    GraphNode(String name) {
        this.nodeName = name;
    }
}

