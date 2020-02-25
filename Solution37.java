class Solution {
	//子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Interger>> res = new ArrayList<List<Interger>>();
		for(int i = 0; i < (1 << nums.length); i++) {
			List<Integer> sub = new ArrayList<Integer>();
			for(int j = 0; j < nums.length; j++) {
				if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
			}
		}
		return res;
    }
}