package 寒假作业;

import java.util.Stack;

public class Solution25 {
    //比较含退格的字符串
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> st = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c != '#') {
                st.push(c);
            }else if( !st.empty()) {
                st.pop();
            }
        }
        return String.valueOf(st);
    }
}
