package datastructure.stack;

public class GenericStack<E> {

    private static class Node<E> {
        private E value;
        private Node<E> prev;
        Node(E value, Node<E> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    private Node<E> top = null;

    public void push(E element) {
        Node<E> newNode = new Node<>(element, top);
        top = newNode;
    }

    public E pop() {
        if (top == null) {
            return null;
        }
        Node<E> taken = top;
        top = top.prev;
        return taken.value;
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(5);

        System.out.println(stack.pop());
    }
}
