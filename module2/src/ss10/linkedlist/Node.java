package ss10.linkedlist;

public class Node {
    public Object data;
    public Node next;

    Node(Object data) {
        this.data = data;
    }

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return this.data;
    }
}
