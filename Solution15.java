package 寒假作业;

import java.util.Arrays;

public class Solution15 {
    //给定一个整数数组，判断是否存在重复元素。
    public boolean containsDuplicate(int[] nums) {
        int[] nums1 = nums;
        Arrays.sort(nums1);
        for(int i = 0; i < nums1.length - 1; i++) {
            if(nums1[i] == nums1[i + 1])
                return true;
        }
        return false;
    }
}
