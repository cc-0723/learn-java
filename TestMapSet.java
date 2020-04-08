package 数据结构;

import java.util.*;

public class TestMapSet {

    static class IntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void testMap() {
        Map<String, String> mp = new TreeMap<>();
        //插入
        mp.put("张大山", "123456");
        mp.put("刘一山", "321456");
        mp.put("萧山", "223456");
        mp.put("刘某", "321321");
        mp.put("牛奶", "789456");
//        System.out.println(mp.get("牛奶"));
//        System.out.println(mp.containsKey("刘某"));
//        System.out.println(mp.containsValue("123456"));
//        System.out.println(mp.containsValue("12345"));
//        System.out.println(mp.getOrDefault("牛奶", "00000"));

        System.out.println("keySet: ");
        Set<String> keySet = mp.keySet();
        for(String key : keySet) {
            System.out.println(key);
        }

        System.out.println("Values: ");
        Collection<String> cl = mp.values();
        for(String e : cl) {
            System.out.println(e);
        }

        System.out.println("EntrySet: ");
        Set<Map.Entry<String, String>> entrySet = mp.entrySet();
        for(Map.Entry<String, String> e : entrySet) {
            System.out.println(e.getKey()  + "---->" + e.getValue());
        }
    }

    public static void testSet() {
        Set<Integer> set = new TreeSet<>();
        set.add(13);
        set.add(-2);
        set.add(99);
        set.add(100);
        set.add(0);
        set.add(25);
        set.add(1001);
        for(Integer in : set) {
            System.out.print(in + " ");
        }
        System.out.println();
        System.out.println("迭代器(搜索树的中序遍历): ");
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

    }

    public static void main(String[] args) {
        //testMap();
        testSet();
    }
}
