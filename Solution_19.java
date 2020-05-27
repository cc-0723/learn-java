package 练习;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] st = sc.nextLine().split(" ");
            ArrayList<Character> A = new ArrayList<>();
            ArrayList<Character> B = new ArrayList<>();
            for(int i = 0; i < st[0].length(); i++) {
                A.add(st[0].charAt(i));
            }
            for(int i = 0; i < st[1].length(); i++) {
                B.add(st[1].charAt(i));
            }
            for(int i = 0; i < B.size(); i++) {
                if(A.contains(B.get(i))) {
                    A.remove(A.get(A.indexOf(B.get(i))));
                    B.remove(i);
                    i--;
                }
            }
            if(B.size() == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
