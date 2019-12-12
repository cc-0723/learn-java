package 数据结构;

import java.util.Stack;

public class StackDemo {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[][] a = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
        for (int i = 0; i < s.length(); i++) {
            char curCh = s.charAt(i);
            int flag = 0;
            for (int j = 0; j < a.length; j++) {
                if (curCh == a[j][0]) {
                    st.push(curCh);
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                if (st.isEmpty())
                    return false;
                char topCh = st.pop();
                for (int m = 0; m < a.length; m++) {
                    if (topCh == a[m][0]) {
                        if (curCh == a[m][1]) {
                            break;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return st.isEmpty();
    }
}

