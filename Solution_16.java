package 练习;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_16 {
    //两个数的交集2
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
             return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1) {
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        int k = 0;
        for(int n  : nums2) {
            int count = map.getOrDefault(n,0);
            if(count > 0) {
                nums1[k++] = n;
                map.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(nums1,0, k);
    }
}
