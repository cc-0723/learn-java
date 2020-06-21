import java.util.*;

public class Solution {
    /**
     * 
     * @param obstacleGrid int整型二维数组 
     * @return int整型
     */
    public int uniquePathsWithObstacles (int[][] obstacleGrid) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        for(int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
            if(obstacleGrid[i][0] == 1)
                list.get(i).add(0);
            else {
                if(i > 0) {
                    if(list.get(i - 1).get(0) == 1) {
                        list.get(i).add(1);
                    } else {
                        list.get(i).add(0);
                    }
                } else 
                    list.get(i).add(1);
            }
        }
        
            for(int i = 1; i < n; i++) {
                if(obstacleGrid[0][i] == 1) {
                    list.get(0).add(0);
                } else {
                    if(list.get(0).get(i - 1) == 1)
                        list.get(0).add(1);
                    else
                        list.get(0).add(0);
                }
            }    
            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    if(obstacleGrid[i][j] == 1)
                        list.get(i).add(0);
                    else 
                        list.get(i).add(list.get(i).get(j - 1) + list.get(i - 1).get(j));
                }
            }
        return list.get(m - 1).get(n - 1);
    }
}