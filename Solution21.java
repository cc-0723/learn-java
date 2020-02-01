package 寒假作业;

public class Solution21 {
    //在该数的基础上加一(123加一成124)
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0)
                return digits;
        }
        //99的这种情况
        digits = new int [digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
