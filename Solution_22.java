package 练习;

import java.util.*;

public class Solution_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String res = "";
        int sum = 0;
        int[] num = new int[n];
        int j = 1;
        for (int i = 0; i < n; i++) {
            num[i] = j++;
        }
        process(num, m, res, sum, 0);
    }

    public static void process(int[] num, int m, String res, int sum, int i) {
        if (i == num.length) {
            if (sum == m) System.out.println(res.trim());
            return;
        }
        process(num, m, res + num[i] + " ", sum + num[i], i + 1);
        process(num, m, res, sum, i + 1);
    }
}
