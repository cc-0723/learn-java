package 数据结构;

import java.util.Stack;

public class MyQueue {          //栈实现队列
    Stack<Integer> pushSt;      //一个栈只出，一个栈只进
    Stack<Integer> popSt;

    public MyQueue() {
        pushSt = new Stack<>();
        popSt = new Stack<>();
    }

    public void push(int x) {
        pushSt.push(x);
    }

    public int pop() {
        if(popSt.isEmpty()) {
            int sz = pushSt.size();
            for(int i = 0; i < sz; i++) {
                popSt.push(pushSt.pop());
            }
        }
        return popSt.pop();
    }

    public int peek() {
        if(popSt.isEmpty()) {
            int sz = pushSt.size();
            for(int i = 0; i < sz; i++) {
                popSt.push(pushSt.pop());
            }
        }
        return popSt.peek();
    }

    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }
}
