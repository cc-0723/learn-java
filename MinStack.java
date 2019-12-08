package 数据结构;

import java.util.Stack;

public class MinStack {     //最小栈
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        st.push(x);
    }

    public void pop() {
        //注意包装类在这里不能直接比较
        //1  int ret = st.peek();
        //自动拆箱，用ret == minStack.peek()去比较
        //或者直接用equals方法
        if(st.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
