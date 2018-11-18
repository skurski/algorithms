package datastructure.list;

public class LinkedList {


    public static void main(String[] args) {
        Node head = new Node('a');
        head.addToTail('b');
        head.addToTail('c');
        head.addToTail('d');
        head.addToTail('e');
        head.addToTail('f');

        // Remove node c from list

}

    private static class Node {
        Node next = null;
        char data;

        Node (char data) {
            this.data = data;
        }

        void addToTail(char data) {
            Node newNode = new Node(data);
            Node head = this;
            while (head.next != null) {
                head = head.next;
            }
            head.next = newNode;
        }

        /**
         * Remove node in the middle, you don't have access to head
         * This is Single Linked List
         *
         * Solution: Copy next data to current and remove next
         */
        boolean removeFromMiddle(Node middle) {
            if (middle == null || middle.next == null) return false;

            Node next = middle.next;
            middle.data = next.data;
            middle.next = next.next;
            return true;
        }
    }
}
