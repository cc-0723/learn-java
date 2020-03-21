package 练习;

import java.util.*;

public class Solution_13 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();
        //统计单词出现的次数
        for(String st : words) {
            mp.put(st, mp.getOrDefault(st, 0) + 1 );
        }
        //建小堆
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> en : mp.entrySet()) {
            pq.offer(en);
            if(pq.isEmpty()) {
                pq.poll();
            }
        }
        //取出堆中的所有元素
        LinkedList<String> list = new LinkedList<>();
        while(!pq.isEmpty()) {
            list.addFirst(pq.poll().getKey());
        }
        return list;
    }
}
