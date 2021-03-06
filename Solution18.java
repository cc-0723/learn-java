package 寒假作业;

import java.util.Stack;

public class Solution18 {
    //仅仅反转字母
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for(char c : S.toCharArray())
            if(Character.isLetter(c))
                letters.push(c);
        StringBuffer ans = new StringBuffer();
        for(char c : S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }
        return ans.toString();
    }
}
