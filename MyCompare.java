package 数据结构;

import java.util.Arrays;
import java.util.Comparator;

public class MyCompare {
    //1.覆写compareTo方法
    //2.实现comparator比较器
     static class Person implements Comparable<Person>{
        public String name;
        public String gender;
        public int age;
        public String id;

        Person(String name, String gender, int age, String id) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.id = id;
        }

         @Override
         public int compareTo(Person o) {
             int ret = age - o.age;
             if(ret > 0)
                 return 1;
             else if(ret < 0)
                 return -1;
             else
                 return 0;
         }

         @Override
         public String toString() {
             return (name + "--" + gender + "--" + age + "--" + id);
         }
     }

     static class PersonAgeComparator implements Comparator<Person> {

         @Override
         public int compare(Person o1, Person o2) {
             int ret = o1.age - o2.age;
             if(ret > 0)
                 return 1;
             else if(ret < 0)
                 return -1;
             else
                 return 0;
         }
     }

     static class PersonIDComparator implements Comparator<Person> {

         @Override
         public int compare(Person o1, Person o2) {
             return o1.compareTo(o2);
         }
     }

    public static void main(String[] args) {
        Person[] PersonArr = {new Person("张三", "男",20, "1234"),
                new Person("李四", "男",25, "1235"),
                new Person("张大山", "男",28, "122"),
                new Person("王一山", "男",15, "13332145"),};
        //实现compareTo方法，只能实现默认的排序规则
        Arrays.sort(PersonArr);
        System.out.println("比较年龄：");
        System.out.println(Arrays.toString(PersonArr));
        //实现比较器，可以灵活的实现多种排序规则，相当于又一个类来专门负责
        System.out.println("比较ID：");
        Arrays.sort(PersonArr, new PersonIDComparator());
        System.out.println(Arrays.toString(PersonArr));

    }
}
