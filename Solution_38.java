import java.util.*;

public class Solution {
    /**
     * 
     * @param S string字符串 
     * @param T string字符串 
     * @return int整型
     */
    public int numDistinct (String S, String T) {
        int s = S.length();
        int t = T.length();
        int[][] arr = new int [s + 1][t + 1];
        arr[0][0] = 1;
        for(int i = 1; i <= s; i++)
            arr[i][0] = 1;
        for(int i = 1; i <= t; i++)
            arr[0][i] = 0;
        
        for(int i = 1; i <= s; i++) {
            for(int j = 1; j <= t; j++) {
                if(S.charAt(i - 1) == T.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[s][t];
    }
}