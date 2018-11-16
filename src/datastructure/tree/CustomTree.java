package datastructure.tree;

import java.util.*;

/**
 * Tree data structure implementation
 */
public class CustomTree {

    public static void main(String[] args) {
		Node a = new Node(1, null, null);
		Node b = new Node(2, a, null);
		Node c = new Node(3, b, null);
		
		Node x = new Node(8, null, null);
		Node y = new Node(9, x, null);
		
		Node root = new Node(4, c, y);
		
		System.out.println("In order traverse: -------------------");
		traverseInOrder(root);
		System.out.println("Pre order traverse: -------------------");
		traversePreOrder(root);
		System.out.println("Post order traverse: -------------------");
		traversePostOrder(root);
		
		System.out.println("Max height: " + maxHeight(root));
    }
	
	public static void traverseInOrder(Node root) {
		if (root == null) return;
		traverseInOrder(root.left);
		System.out.println("Tree value: " + root.value);
		traverseInOrder(root.right);
	}
	
	public static void traversePreOrder(Node root) {
		if (root == null) return;
		System.out.println("Tree value: " + root.value);
		traverseInOrder(root.left);
		traverseInOrder(root.right);
	}
	
	public static void traversePostOrder(Node root) {
		if (root == null) return;
		traverseInOrder(root.left);
		traverseInOrder(root.right);
		System.out.println("Tree value: " + root.value);
	}
	
	public static int maxHeight(Node node) {
		if (node == null) return 0;
		int leftHeight = maxHeight(node.left);
		int rightHeight = maxHeight(node.right);
		
		if (leftHeight > rightHeight) return leftHeight + 1;
		return rightHeight + 1;
	}
	
	private static class Node {
		Node left;
		Node right;
		int value;
		
		Node (int value, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}
}
