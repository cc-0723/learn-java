package 寒假作业;

public class Solution10 {
    //回文数
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int y = x;
        while(y != 0) {
            cur = cur * 10 + y % 10;
            y /= 10;
        }
        return cur == x;
    }
}
