package 寒假作业;

import java.util.Stack;

public class Solution27 {
    //栈的弹出压入序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> st = new Stack<Integer>();
        int j = 0;
        for(int i = 0; i < popA.length; i++) {
            st.push(pushA[i]);
            while(j < popA.length && st.peek() == popA[j]) {
                st.pop();
                j++;
            }
        }
        return st.empty() == true;
    }
}
