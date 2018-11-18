package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class Graph {

    private int vertices;

    private Node[] nodes;

    public Graph(int vertices) {
        this.vertices = vertices;
        nodes = new Node[vertices];

        for (int i = 0; i < vertices; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int v1, int v2) {
        nodes[v1].adjList.add(nodes[v2]);
        nodes[v2].adjList.add(nodes[v2]);
    }

    public void DFS(int startNode) {
        if (nodes[startNode] == null) return;
        System.out.print(nodes[startNode].label + " ");
        nodes[startNode].visited = true;

        for (Node node: nodes[startNode].adjList) {
            if (!node.visited) DFS(node.label);
        }
    }

    public void reset() {
        Arrays.stream(nodes).forEach(node -> node.visited = false);
    }

    public void BFS(int startNode) {
        Queue<Node> queue = new LinkedList<>();
        nodes[startNode].visited = true;
        queue.add(nodes[startNode]);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.label + " ");

            for (Node children: node.adjList) {
                if (!children.visited) {
                    children.visited = true;
                    queue.add(children);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("DFS:");
        graph.DFS(2);
        graph.reset();

        System.out.print("\nBFS:");
        graph.BFS(2);
    }

    private static class Node {
        int label;
        ArrayList<Node> adjList;
        boolean visited = false;

        Node (int label) {
            this.label = label;
            adjList = new ArrayList<>();
        }
    }
}
