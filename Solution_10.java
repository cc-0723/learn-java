package 练习;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution_10 {
    //找包含多少相同的字母
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new TreeSet<>();
        for(char ch : J.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for(char ch : S.toCharArray()) {
            if(set.contains(ch))
                count++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String right = scanner.nextLine();
        String wrong = scanner.nextLine();

        Set<Character> wrongSet = new HashSet<>();
        for(char ch : wrong.toCharArray()) {
            wrongSet.add(ch);
        }

        Set<Character> printSet = new HashSet<>();
        for(char ch : right.toCharArray()) {
            if(!wrongSet.contains(ch)) {
                ch = Character.toUpperCase(ch);
                if(!printSet.contains(ch)) {
                    printSet.add(ch);
                    System.out.print(ch);
                }
            }
        }
    }
}
