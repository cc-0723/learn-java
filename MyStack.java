package 数据结构;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {          //一个队列实现栈
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while(size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }

    public int top() {
        int size = queue.size();
        while(size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        int ret = queue.poll();
        queue.offer(ret);
        return ret;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

