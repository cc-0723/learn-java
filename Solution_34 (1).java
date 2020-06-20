public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        int num = A.length;
        if(m == 0 || num == 0)
            return 0;
        int[] max = new int [m + 1];
        for(int i = 0; i <= m; i++) {
            max[i] = 0;    
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = m; j > 0; j--) {
                if(A[i - 1] <= j) {
                    int new = max[j - A[i - 1]] + V[i - 1];
                    max[j] = Math.max(new, max[j]);
                }
            }
        }
        return max[m];
        
    }
}