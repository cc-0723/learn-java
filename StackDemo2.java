package 数据结构;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    private HashMap<Character,Character> mappings;

    public Solution() {
        this.mappings = new HashMap<>();
        this.mappings.put('(',')');
        this.mappings.put('[',']');
        this.mappings.put('{','}');
    }

    public class StackDemo2 {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i ++) {
                char c = s.charAt(i);
                if (this.mappings.containsKey()) {
                    char topElement = stack.empty() ? '#' : stack.pop();
                if(topElement != stack.mappings.get(c)) {
                    return false;
                }
            }else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }

    }
}

