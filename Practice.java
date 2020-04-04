package 练习;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int q = sc.nextInt();
            if(q != 0) {
                System.out.println(q / 2);
            }
        }
    }
}
