package 数据结构;

class Node{
    int value;
    Node next;
}

public class Queue {        //链表实现栈
    Node front;
    Node rear;
    int size;

    public Queue() {
        Node front = rear = null;
        size = 0;
    }

    public void offer(int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if(front == null) {
            front = rear = node;
        }else {
            rear.next = node;
            rear = rear.next;
        }
        size++;
    }

    public void poll() {
       if(front == null)
           return;
       front = front.next;
       if(front == null)
           rear = null;
       size--;
    }

    public int peek() {
        if(front == null)
            return -1;
        return front.value;
    }

    public int size() {
        return size;
    }

    public int rear() {
        if(front == null)
            return -1;
        return rear.value;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        while(!q.isEmpty()) {
            System.out.println("栈顶元素：" + q.peek());
            q.poll();
        }
    }
}

