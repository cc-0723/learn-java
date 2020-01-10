package 寒假作业;

public class Solution6 {
    //移除元素
    public int removeElement(int[] nums, int val) {
        int prev = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[prev] = nums[i];
                prev++;
            }
        }
        return prev;
    }
}
