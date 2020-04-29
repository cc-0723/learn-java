package 第一章栈和队列;

import java.util.Stack;

public class inverseStack {
    //用递归实现栈逆序
    Stack<Integer> st = new Stack<>();

    //递归得到栈底元素
    public int getAndRemoveLastElement(Stack<Integer> st) {
        int resule = st.pop();
        if(st.isEmpty()) {
            return resule;
        } else {
            int ans = getAndRemoveLastElement(st);
            st.push(resule);
            return ans;
        }
    }

    public void reverse(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int num = getAndRemoveLastElement(st);
        reverse(st);
        st.push(num);
    }
}
