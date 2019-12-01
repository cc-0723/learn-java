package 数据结构;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<String>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("比特");
        list.add("科技");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));

        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("============");
        list.remove("科技");

        for(String s : list) {
            System.out.println(s);
        }

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        System.out.println("=============");
        list.clear();
        System.out.println(list.size());

    }
}
