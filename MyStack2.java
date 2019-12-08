package 数据结构;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {         //俩个队列实现栈
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if(q1.isEmpty()){
            q2.offer(x);
        }else {
            q1.offer(x);
        }
    }

    public int pop() {
       int ret = 0;
       if(q1.isEmpty()) {
           int sz = q2.size();
           while(sz > 1) {
               q1.offer(q2.poll());
               sz--;
           }
           ret = q2.poll();
       }else {
           int sz = q1.size();
           while(sz > 1) {
               q2.offer(q1.poll());
               sz--;
           }
           ret = q1.poll();
       }
       return ret;
    }

    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
