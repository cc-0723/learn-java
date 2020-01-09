package 寒假作业;

public class Solution1 {
    public static void mystery(int x) {
        System.out.print(x % 10); //模运算，取余 1234 123 12 1
        if ((x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.print(x % 10);//1 12 123 1234
    }

    public static void main(String[] args) {
        mystery(1234);     //43211234
    }
}
