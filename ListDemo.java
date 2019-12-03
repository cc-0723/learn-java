package 数据结构;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("李白");
        list.add("鲁班");
        list.add("程咬金");
        list.add("鲁班");
        System.out.println(list);

        list.add(2,"王者");
        list.add(3,"荣耀");
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(3));

        list.set(1,"小鲁班");              //修改值
        System.out.println(list);

        List<String> subList = list.subList(1,4);
        System.out.println(subList);

        List<String> list2 = new ArrayList<>(list);        //全部拷贝
        System.out.println(list2);

        ArrayList<String> list3 = (ArrayList<String>)list;          //引用转换
        System.out.println(list3);

    }
}
