package 练习;

import java.util.HashMap;
import java.util.Map;

public class Solution_14 {
    //同构字符串
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)) {
                if(map.get(c1) != c2)
                    return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}













