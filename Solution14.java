package 寒假作业;

public class Solution14 {
    String str = new String("hello");//hello and cb
    char[] ch = {'a', 'b'};

    public static void main(String args[]) {
        Solution14 sol = new Solution14();
        sol.change(sol.str, sol.ch);
        System.out.print(sol.str + " and ");
        System.out.print(sol.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'c';
    }
}
