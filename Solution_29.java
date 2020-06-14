public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0], cur = array[0];
        for(int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            if(cur > max)
                max = cur;
        }
        return max;
    }
}