package ss10.linkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addFirst(0);
        linkedList.add(3, 6);
//        linkedList.removeElement(5);
        linkedList.showData();
        System.out.println(linkedList.removeByIndex(3));;
        linkedList.showData();
    }
}
