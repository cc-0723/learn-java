package 练习;

import java.util.Map;
import java.util.TreeMap;

public class Solution_9 {
    //只出现一次的数字
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums) {
            if(map.get(num) == 1)
                return 1;
        }
        return -1;
    }
}

class Solution2 {
    //异或运算
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int num : nums)
            ret ^= num;
        return ret;
    }
}




