package 寒假作业;

import java.util.Arrays;

public class Solution17 {
    //有序数组的平方
    public int[] sortedSquares(int[] A) {
        int[] a = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            a[i] = A[i] * A[i];
        }
        Arrays.sort(a);
        return a;
    }
}
