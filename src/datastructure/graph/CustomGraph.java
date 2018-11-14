package datastructure.graph;

import java.util.*;

/**
 * Graph example:
 * http://www.algolist.net/Data_structures/Graph
 * Photo with weighted graph
 *
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class CustomGraph {

	private Map<Integer, Node> graph = new HashMap<>();
	
	public static void main(String[] args) {
		CustomGraph custom = new CustomGraph();
		custom.graph.put(1, new Node(1));
		custom.graph.put(2, new Node(2));
		custom.graph.put(3, new Node(3));
		custom.graph.put(4, new Node(4));
		custom.graph.put(5, new Node(5));
		
		custom.graph.get(1).addNodeToList(custom.graph.get(2)).addNodeToList(custom.graph.get(4));
		custom.graph.get(2).addNodeToList(custom.graph.get(1)).addNodeToList(custom.graph.get(3))
				.addNodeToList(custom.graph.get(4))
				.addNodeToList(custom.graph.get(5));
		custom.graph.get(3).addNodeToList(custom.graph.get(2)).addNodeToList(custom.graph.get(5));	
		custom.graph.get(4).addNodeToList(custom.graph.get(1)).addNodeToList(custom.graph.get(2))
				.addNodeToList(custom.graph.get(5));
		custom.graph.get(5).addNodeToList(custom.graph.get(2)).addNodeToList(custom.graph.get(3))
				.addNodeToList(custom.graph.get(4));
	}
	
	public static class Node {
		int label;
		List<Node> adjacencyList = new ArrayList<>();
		
		Node (int label) {
			this.label = label;
		}
		
		Node addNodeToList(Node node) {
			this.adjacencyList.add(node);
			return this;
		}
	}
}
