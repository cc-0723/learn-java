package String;

import java.util.Stack;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if(s.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if(s.equals("-")) {
                st.push( -st.pop() + st.pop());
            } else if(s.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if(s.equals("/")) {
                int ret = st.pop();
                st.push(st.pop() / ret);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
