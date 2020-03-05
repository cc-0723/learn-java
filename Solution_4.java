package 寒假练习;

import java.util.Arrays;

public class Solution_4 {
    //最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        int weight = 0;
        for(int i = 0; i < stones.length - 1; i++) {
            Arrays.sort(stones);
            weight = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            stones[stones.length - 1] = weight;
        }
        return stones[stones.length - 1];
    }
}
