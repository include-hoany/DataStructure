package queue.lifoqueue;

public class LifoQueue<T> {
    private int size = 0;
    private Node<T> firstNode = null;

    public boolean enQueue(T data) {
        if (firstNode == null) {
            firstNode = new Node<>(data);
            size++;
            return true;
        }

        if (firstNode != null) {
            Node enRollNode = new Node(data);
            enRollNode.next = firstNode;
            firstNode = enRollNode;
            size++;
            return true;
        }

        return false;
    }

    public T deQueue() {
        Node<T> getNode = firstNode;
        if (getNode == null) return null;
        firstNode = firstNode.next;
        size--;
        return getNode.data;
    }

    public int getSize() {
        return size;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Main {
    public static void main(String[] args) {
        LifoQueue<Integer> integerQueue = new LifoQueue<>();

        integerQueue.enQueue(1);
        integerQueue.enQueue(2);
        integerQueue.enQueue(3);
        System.out.println(integerQueue.getSize());

        System.out.println(integerQueue.deQueue());
        System.out.println(integerQueue.deQueue());
        System.out.println(integerQueue.deQueue());
        System.out.println(integerQueue.getSize());
    }
}