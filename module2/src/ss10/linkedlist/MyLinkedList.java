package ss10.linkedlist;

public class MyLinkedList<E> {
    private Node head;
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
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
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
        numNodes++;
    }

    public void checkIndex(int index){
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Out of index: " + index);
        }
    }

    public void add(int index, E element) {
        checkIndex(index);
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == numNodes) {
            addLast(element);
            return;
        }
        Node curr = head;
        while (--index != 0) {
            curr = curr.next;
        }
        Node node = new Node(element);
        Node temp = curr.next;
        curr.next = node;
        node.next = temp;
        numNodes++;
    }

    public boolean removeElement(E element) {
        if (head == null) return false;
        if (head.data == element) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node prevNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            if (curNode.data == element) {
                prevNode.next = curNode.next;
                numNodes--;
                return true;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        return false;
    }

    public E removeByIndex(int index) {
        checkIndex(index);
        if (head == null) return null;

        Node prevNode = head;
        Node curNode = head.next;
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) prevNode;
        }
        while (--index != 0) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        prevNode.next = curNode.next;
        numNodes--;
        return (E) curNode;
    }

    public boolean contains(E e){
        Node temp = head;
        while (temp != null) {
            if (temp.data == e) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public E get(int index){
        checkIndex(index);
        Node temp = head;
        while (index-- != 0) {
            temp = temp.next;
        }
        return (E) temp;
    }

    public int indexOf(E e) {
        int result = 0;
        if (head == null) return -1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == e) return result;
            result++;
            temp = temp.next;
        }
        return -1;
    }

    public void clear(){
        head = null;
    }
    public int size(){
        return numNodes;
    }

    public E clone(){
        return (E) head;
    }

    public void showData() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            String split = temp != null? "," : "\n";
            System.out.print(split);
        }
    }
}
