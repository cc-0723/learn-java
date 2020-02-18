class Solution {
	//最短无序连续子数组
    public int findUnsortedSubarray(int[] nums) {
        int[] nums1 = nums.clone();
		Arrays.sort(nums1);
		int start = nums1.length, end = 0;
		for(int i = 0; i < nums1.length; i++) {
			if(nums1[i] != nums[i]) {
				start = Math.min(start, i);
                end = Math.max(end, i);
			}
		}
		return (end - start >= 0 ? end - start + 1 : 0);
    }
}