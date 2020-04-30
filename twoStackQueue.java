package 第一章栈和队列;

import java.util.Stack;

public class twoStackQueue {
    Stack<Integer> stPush = new Stack<>();
    Stack<Integer> stPop = new Stack<>();

    public void add(int num) {
        if(!stPush.isEmpty()) {
            stPush.push(num);
        }
    }

    public int poll() {
        if(stPush.isEmpty() && stPop.isEmpty()) {
            throw new RuntimeException("栈为空");
        } else if (stPop.empty()){
            while (!stPush.isEmpty()) {
                stPop.push(stPush.pop());
            }
        }
        return stPop.pop();
    }

    public int peek() {
        return stPop.peek();
    }
}
