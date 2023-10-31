package top75.graph;

import java.util.*;

public class DFS extends Graph{

    public DFS(List<GraphNode> list) {
        super(list);

    }

    public ArrayList<String> depthFirstSearch(GraphNode start){
        ArrayList<GraphNode> visited = new ArrayList<>();
        Stack<GraphNode> stk = new Stack<>();
        stk.push(start);
        while (!stk.isEmpty()){
            GraphNode currentGraphNode = stk.pop();
            if (!visited.contains(currentGraphNode)){
                visited.add(currentGraphNode);
                for (GraphNode n : adjList.get(currentGraphNode)){
                    stk.push(n);
                }
            }
        }

        ArrayList<String> dfs = new ArrayList<>();
        for(GraphNode n : visited)
            dfs.add(n.nodeName);
        return dfs;

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
        DFS g = new DFS(list);
        g.addEdge(a, e);
        g.addEdge(a, d);
        g.addEdge(d, e);
        g.addEdge(b, e);
        g.addEdge(b, c);

        //print the adjacency list
        System.out.println("Depth First Traversal starting from E: ");

        ArrayList<String> outputVertex = g.depthFirstSearch(a);
        for (String vertex: outputVertex) {
            System.out.println(vertex + " - Traversed ");
        }
    }
}

