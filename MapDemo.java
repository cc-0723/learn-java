package 数据结构;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("=============");

        map.put("作者","鲁迅");                 //插入
        map.put("标题","狂人日记");
        map.put("出版社","北京");
        map.put("页数","300");

        for(Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
        System.out.println(map.size());
        System.out.println("==============");

        map.put("出版时间", "1919");
        map.put("出版社","天津");                    //修改
        map.put("页数","200");
        for(Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
        System.out.println(map.size());
        System.out.println("==============");

        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsKey("标题"));
        System.out.println(map.containsKey("北京"));
        System.out.println("==============");

        System.out.println(map.containsValue("329"));
        System.out.println(map.containsValue("123"));
        System.out.println(map.containsValue("出版社"));
        System.out.println("==============");

        System.out.println(map.get("作者"));
        System.out.println("==============");

        map.clear();
        System.out.println(map.size());

    }
}
