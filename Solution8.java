package 寒假作业;

public class Solution8 {
    //二分查找
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(nums.length == 0)
            return -1;

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid]< target)
                left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
