package 人工智能实验;

import java.util.Scanner;

public class Solution_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] st = str.split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = st.length - 1; i >= 0; i--) {
            sb.append(st[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
