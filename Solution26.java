package 寒假作业;

import java.util.Stack;

public class Solution26 {
    //棒球比赛
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String op : ops) {
            if(op.equals("+")) {
                int ret = st.pop();
                int newret = ret + st.peek();
                st.push(ret);
                st.push(newret);
            }else if(op.equals("D")) {
                st.push(st.peek() * 2);
            }else if(op.equals("C")) {
                st.pop();
            }else {
                st.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int sc : st)
            ans += sc;
        return ans;
    }
}
