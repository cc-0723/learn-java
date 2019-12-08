package 数据结构;

public class MyCircularQueue {      //循环队列
    private int [] array;       //保留一个位置
    private int front;
    private int rear;           //队尾的下一个位置

    public MyCircularQueue(int k) {
        array = new int [k + 1];
        front = rear = 0;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        array[rear ++] = value;     //尾插
        rear = rear % array.length;     //判断是否越界
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        front++;        //头删
        front = front % array.length;       //判断是否越界
        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;
        return array[front];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
       if(rear == 0)        //元素在rear - 1的位置上
           return array[array.length - 1];
       return array[rear - 1];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }
}

