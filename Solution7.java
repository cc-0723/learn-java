package 寒假作业;

public class Solution7 {
    //搜索插入位置(使用二分查找)
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(nums[len - 1] < target)
            return len;

        int left = 0, right = len - 1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
