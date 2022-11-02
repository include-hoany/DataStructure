package queue;

public class FifoQueue<T> {

    private int size = 0;
    private Node<T> firstNode = null;

    public boolean enQueue(T data) {
        if (firstNode == null) {
            firstNode = new Node<>(data);
            size++;
            return true;
        }

        if (firstNode != null) {
            Node<T> searchNode = firstNode;
            while (searchNode.next != null) {
                searchNode = searchNode.next;
            }
            searchNode.next = new Node<T>(data);
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
        FifoQueue<Integer> integerQueue = new FifoQueue<>();

        integerQueue.enQueue(1);
        integerQueue.enQueue(1);
        integerQueue.enQueue(1);
        System.out.println(integerQueue.getSize());

        System.out.println(integerQueue.deQueue());
        System.out.println(integerQueue.deQueue());
        System.out.println(integerQueue.deQueue());
        System.out.println(integerQueue.getSize());
    }
}
