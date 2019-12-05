package doubly_list;

public class MyLinkedList {
    private Node head = null;
    private Node last = null;
    private int size = 0;

    public void pushFront(int val) {
        Node node = new Node(val);
        node.next = head;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(head.next == null) {
            last = head;
        }
        size++;
    }

    public void popFront() {
        if(size == 0) {
            throw new RuntimeException("空的");
        }
        head = head.next;
        if(head != null) {
            head.prev = null;
        }else {
            last = null;
        }
        size--;
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        if(last != null) {
            last.next = node;
        }else {
            head = node;
        }
        node.prev = last;
        last = node;
        size++;
    }

    public void popBack() {
        if(size == 0) {
            throw new RuntimeException("空的");
        }
        if(last.prev != null) {
            last.prev.next = null;
            last = last.prev;
        }else {
            head = last = null;
        }
        size--;
    }

    public void reset() {
        head = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for(Node cur = head; cur != null; cur = cur.next) {
            s += String.format("%d --> ",cur.val);
        }
        s += "null";
        return s;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushFront(4);
        list.pushFront(3);
        list.pushFront(2);
        list.pushFront(1);
        System.out.println(list);
        list.popFront();
        list.popFront();
        System.out.println(list);
        list.pushBack(7);
        list.pushBack(8);
        list.pushBack(9);
        System.out.println(list);
        list.popBack();
        list.popBack();
        System.out.println(list);
    }

}
