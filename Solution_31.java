import java.util.*;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(triangle);
        int row = list.size();
        for(int i = row - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int cur = Math.min(triangle.get(i + 1).get(j), 
                                   triangle.get(i + 1).get(j + 1)) + 
                    triangle.get(i).get(j);
                list.get(i).set(j, cur);
            }
        }
        return list.get(0).get(0);
    }
}