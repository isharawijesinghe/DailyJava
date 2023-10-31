package top75.graph;

import java.util.*;

public class BFS extends Graph{

    public BFS(List<GraphNode> list) {
        super(list);
    }

    public ArrayList<String> breathFirstSearch(GraphNode start){
        ArrayList<GraphNode> visited = new ArrayList<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add( start);
        while (!queue.isEmpty()){
            GraphNode currentGraphNode = queue.poll();
            for (GraphNode n : adjList.get(currentGraphNode)){
                if (!visited.contains(n)) {
                    queue.add(n);
                    visited.add(n);
                }
            }
        }

        ArrayList<String> bfs = new ArrayList<>();
        for(GraphNode n : visited)
            bfs.add(n.nodeName);
        return bfs;

    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");
        GraphNode e = new GraphNode("E");

        ArrayList<GraphNode> list = new ArrayList<GraphNode>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        //Constructing the graphs
        BFS g = new BFS(list);
        g.addEdge(a, e);
        g.addEdge(a, d);
        g.addEdge(d, e);
        g.addEdge(b, e);
        g.addEdge(b, c);

        //print the adjacency list
        System.out.println("Breath First Traversal starting from E: ");

        ArrayList<String> outputVertex = g.breathFirstSearch(e);
        for (String vertex: outputVertex) {
            System.out.println(vertex + " - Traversed ");
        }
    }
}
