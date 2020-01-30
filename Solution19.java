package 寒假作业;

public class Solution19 {
    //按奇偶排序数组
    public int[] sortArrayByParity(int[] A) {
        int [] sort = new int [A.length];
        int j = 0;
        //输出偶数
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 ==0)
                sort[j++] = A[i];
        }
        //输出奇数
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 1)
                sort[j++] = A[i];
        }
        return sort;
    }
}
