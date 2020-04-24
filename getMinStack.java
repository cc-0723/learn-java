package 第一章栈和队列;

import org.omg.SendingContext.RunTime;

import java.util.Stack;

public class getMinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st1 = new Stack<>();

    public void push(int num) {
        if(st1.isEmpty()) {
            st1.push(num);
        } else if (st.peek() <= getMin()) {
            st1.push(num);
        } else {
            st.push(num);
        }
    }

    public int pop() {
      if(st.isEmpty()) {
          throw new RuntimeException("栈为空");
      }
      int val = st.peek();
      if(val == getMin()) {
          st1.pop();
      }
      return val;
    }

    public int getMin() {
        if(st.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return st1.peek();
    }
}
