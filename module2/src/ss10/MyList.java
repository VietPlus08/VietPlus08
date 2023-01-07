package ss10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyList<E> {
    int size = 0;
    final static int DEFAULT_CAPACITY = 10;
    Object[] elements;

    List<String> list = new ArrayList<>();

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index >= elements.length || index < 0)
            throw new IndexOutOfBoundsException();
        Object[] newElements = new Object[elements.length + 1];
        for (int i = 0; i < newElements.length; i++) {
            if (i < index) {
                newElements[i] = elements[i];
                continue;
            }
            if (i >= index) {
                newElements[i + 1] = elements[i];
                continue;
            }
            newElements[i] = element;
        }
    }

    public static void main(String[] args) {
        MyList<Integer> ints = new MyList<>();
        ints.add(1, 2);
        System.out.println(ints.toString());

    }
}
