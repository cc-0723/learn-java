package 练习;

import java.util.ArrayList;
import java.util.List;

public class Solution_17 {
    //找到 k个最接近的匀速
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;

        while(left < right) {
            int mid = (left + right) >>> 1;
            if(x - arr[mid] >  arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res =  new ArrayList<>();
        for(int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
