import java.util.*;

public class Solution {
    /**
     * 
     * @param m int整型 
     * @param n int整型 
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //初始化
        for(int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(1);
        }
         for(int i = 1; i < n; i++) {
            list.get(0).add(1);
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                list.get(i).add(list.get(i).get(j - 1) + list.get(i - 1).get(j));
            }
        }
        return list.get(m - 1).get(n - 1);
    }
}