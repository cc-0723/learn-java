package 寒假练习;

public class Solution_1 {
    public static void main(String[] args) {
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
        //~j 相当于 - j - 1
        //i + ~j 相当于i + (- j - 1)
    }
}
