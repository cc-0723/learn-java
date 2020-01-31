package 寒假作业;

public class Solution20 {
    //寻找数组的中心索引,左边元素的和等于右边元素的和，返回这个中心索引
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftsum = 0;
        for(int x : nums) {
            sum += x;
        }
        for(int i = 0; i < nums.length; i++) {
            if(leftsum == sum - nums[i] - leftsum)
                return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
