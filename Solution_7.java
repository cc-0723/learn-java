package 寒假练习;

public class Solution_7 {
    //true true
    public static void main(String[] args) {
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i == j);
        System.out.println(j.equals(i));
    }
}

class Test {
    public String name="abc";
    //false true
    public static void main(String[] args){
        Test test=new Test();
        Test testB=new Test();
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
    }
}

class Test2 {
    //true
    public static void main(String[] args){
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
}
