package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    public void add(int element) {
        if (root == null) {
            this.root = new Node(null, null, element);
            return;
        }

        Node node = root;
        Node prev = root;
        while (node != null) {
            prev = node;
            if (node.value == element) {
                return;
            } else if (node != null && node.value > element) {
                node = node.left;
            } else if (node != null && node.value < element) {
                node = node.right;
            }
        }

        if (prev.value > element) {
            prev.left = new Node(null, null, element);
        } else {
            prev.right = new Node(null, null, element);
        }
    }

    public void traverseInOrder() {
        this.dfs(root);
    }

    private void dfs(Node node) {
        if (node == null) return;
        dfs(node.left);
        System.out.println(node.value);
        dfs(node.right);
    }

    public void breadthFristTraversal() {
        this.bfs(root);
    }

    private void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node nodeToVisit = queue.poll();
            System.out.println(nodeToVisit.value);

            if (nodeToVisit.left != null) queue.add(nodeToVisit.left);
            if (nodeToVisit.right != null) queue.add(nodeToVisit.right);
        }
    }

    public int maxHeight() {
        return this.checkMaxHeight(root);
    }

    private int checkMaxHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = checkMaxHeight(node.left);
        int rightHeight = checkMaxHeight(node.right);

        if (leftHeight > rightHeight) return leftHeight + 1;
        return rightHeight + 1;
    }

    private static class Node {
        Node left;
        Node right;
        int value;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(10);
        bst.add(5);
        bst.add(11);
        bst.add(3);
        bst.add(4);
        bst.add(15);

        System.out.println("Depth first traversal: ");
        bst.traverseInOrder();

        System.out.println("Breadth first traversal: ");
        bst.breadthFristTraversal();

        System.out.println("Check max height of the tree: " + bst.maxHeight());
    }
}
