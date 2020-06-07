package 人工智能实验;

import java.util.Scanner;

public class Solution_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] st = str.split("_");
            String tmp = st[0];
            for (int i = 1; i < st.length; i++) {
                tmp += (char) (st[i].charAt(0) - 'a' + 'A');
                for (int j = 1; j < st[i].length(); j++) {
                    tmp += st[i].charAt(j);
                }
            }
            System.out.println(tmp);
        }
    }
}
