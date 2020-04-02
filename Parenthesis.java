package 练习;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int i = 0;
        for (char ch : A.toCharArray()) {
            if (ch == '(') {
                st1.push(ch);
            } else if (ch == ')') {
                st2.push(ch);
            } else {
                continue;
            }
        }
        while(i < n) {
            if (st1.peek() != st2.peek()) {
                st1.pop();
                st2.pop();
                i++;
            }
        }
        return st1.isEmpty() && st2.isEmpty();
    }
}