package ss10.linkedlist;

public class MyLinkedList<E> {
    private Node head;
    Node lastNode;
    private int numNodes;

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(Object data) {
        numNodes++;
        head = new Node(data);
    }

    public void addLast(E data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
            }
        temp.next = node;
        numNodes++;
    }

    public void addFirst(E data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
        this.numNodes++;
    }

    public void add(int index, E element) {
        if (index <= 0) {
            addFirst(element);
            return;
        }
        if (index > this.numNodes - 1) {
            addLast(element);
            return;
        }

        Node curr = this.head;
        index--;
        while (index-- > 0) {
            curr = curr.next;
        }

        if (curr == null) {
            addLast(element);
        } else {
            Node node = new Node(element);
            Node temp = curr.next;
            curr.next = node;
            node.next = temp;
        }
        numNodes++;
    }

    public void removeElement(E element) {
        if (this.head == null) return;
        Node fakeHead = new Node(new Object(), this.head);
        Node prev = fakeHead;
        Node curr = prev.next;
        while (curr != null) {
            if (curr.data == element) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null) this.lastNode = curr;
        }

        this.head = fakeHead.next;
    }

    public void removeByIndex(int index) {
        if (this.head == null) return;
        if (index > this.numNodes - 1 || index < 0) return;

        Node fakeHead = new Node(new Object(), this.head);
        Node prev = fakeHead;
        Node curr = prev.next;

        while (index-- > 0) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        this.head = fakeHead.next;
    }

    public int indexOf(E element) {
        if (this.head == null) return 0;
        int result = 0;
        Node head = this.head;
        while (head != null) {
            if (head.data == element) break;
            result++;
            head = head.next;
        }
        return result;
    }

    public void showData() {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
