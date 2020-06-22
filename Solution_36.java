import java.util.*;


public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return int整型
     */
    public int minCut (String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[] arr = new int[len + 1];
        for(int i = 0; i <= len; i++) {
            arr[i] = i - 1;
        }
        
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                if(isPal(s, j, i - 1)) {
                    arr[i] = Math.min(arr[i], arr[j] + 1);
                }
            }
        }
        return arr[len];
    }
    
    public static boolean isPal(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}