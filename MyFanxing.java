package 数据结构;


import java.util.Arrays;

public class MyFanxing {

}

class MyArrayList<E> {
    private E[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
        capacity = 10;
    }

    public void add(E value) {
        if(size == capacity) {
            array = Arrays.copyOf(array,2 * capacity);
            capacity *= 2;
        }
        array[size++] = value;
    }

    public E remove() {
        E ret;
        if(size > 0) {
            ret = array[size - 1];
            array[size - 1] = null;
            size--;
            return ret;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void print() {
        for(E e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList<Integer>  m = new MyArrayList<>();
        MyArrayList<Character> m2 = new MyArrayList<>();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);
        m.add(6);
        m.print();

        m2.add('a');
        m2.add('b');
        m2.add('c');
        m2.add('d');
        m2.add('e');
        m2.add('f');
        m2.print();

    }

}

class MyList<E> {
    private static class Node<E> {
        private E value;
        Node<E> next;

        private Node(E value) {
            this.value = value;
            next = null;
        }
    }

    private Node<E> head;

    public void pushFront(E value) {
        if(head == null) {
            head = new Node<>(value);
        } else {
            Node<E> node = new Node(value);
            node.next = head;
            head = node;
        }
    }

    public E popFront() {
        E ret = head.value;
        head = head.next;
        return ret;
    }

    public static void main(String[] args) {
        MyList<Integer> mn = new MyList();
        mn.pushFront(1);
        mn.pushFront(2);
        mn.pushFront(3);
        mn.pushFront(4);
        mn.pushFront(5);
        int ret = mn.popFront();
    }
}
