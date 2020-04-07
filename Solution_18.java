package 练习;

import java.util.*;

public class Solution_18 {
    //前 k 个高频单词
    public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for(String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

       //建堆
       PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>();
       for(Map.Entry<String, Integer> en : map.entrySet()) {
           pq.offer(en);
           if(pq.isEmpty()){
               pq.poll();
           }
       }
       //取出元素
       LinkedList<String> list = new LinkedList<>();
       while(!list.isEmpty()) {
           list.addFirst(pq.poll().getKey());
       }
       return list;
    }
}

