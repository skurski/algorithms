package datastructure.list;


public class DoubleLinkedList {

    private Node head;

    private Node tail;

    public DoubleLinkedList() {

    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void iterate() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data + ", " + node.prev + ", " + node.next);
            node = node.next;
        }
    }

    // let assume that there is no duplicates
    public boolean remove (int data) {
        if (head.data == data) {
            head = head.next;
            head.prev = null;
            return true;
        }

        if (tail.data == data) {
            tail = tail.prev;
            tail.next = null;
            return true;
        }

        Node node = head;
        while (node != null) {
            if (node.data == data) {
                Node prev = node.prev;
                prev.next = node.next;
                node.next.prev = prev;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        list.iterate();
        list.remove(2);
        list.iterate();
    }

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }
}
