package ss10.arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    final static int DEFAULT_CAPACITY = 10;
    final static int EMPTY_CAPACITY = 0;
    Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else if (capacity == 0) {
            elements = new Object[EMPTY_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public int size() {
        return size;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, (int) (minCapacity * 1.5));
        }
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    public void add(int index, E e) {
        ensureCapacity(size + 1);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Out of index: " + index);
        }
        for (int i = size; i >= index; i--) {
            if (i > index) {
                elements[i] = elements[i - 1];
                continue;
            }
            elements[i] = e;
        }
        size++;
    }

    public E remove(int index) {
        checkIndex(index);
        E e = get(index);
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return e;
    }

    public Object clone() {
        return elements;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i) == e){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i) == e){
                return i;
            }
        }
        return -1;
    }

    public void clear(){
        size = 0;
        elements = new Object[0];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Out of index: " + index);
        }
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        MyList<Integer> ints = new MyList<>();
        ints.add(0, 0);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.remove(1);
        System.out.println(ints.toString());
        System.out.println("Size: " + ints.size());
        System.out.println("int[0]: " + ints.get(0));
        ints.clear();
        System.out.println(ints.toString());}
}
