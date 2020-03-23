package 练习;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_15 {
    //两个数组的交集
    public int[] help(Set<Integer> set1, Set<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for(Integer n : set1) {
            if (set2.contains(n))
                output[idx++] = n;
        }
        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(Integer n : nums1)
            set1.add(n);
        for(Integer n : nums2)
            set2.add(n);

        if(set1.size() < set2.size()) {
            return help(set1, set2);
        } else {
            return help(set2, set1);
        }
    }
}
