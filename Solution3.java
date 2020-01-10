package 寒假作业;

public class Solution3 {
    //旋转数组(原地旋转k次)
    public void rotate(int[] nums, int k) {
        int prev, head;
        for(int i = 0; i < k; i++) {
            prev =  nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++) {
                head = nums[j];
                nums[j] = prev;
                prev = head;
            }
        }
    }
}
