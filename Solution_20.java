package 练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            String[] str = new String[n];
            for(int i = 0; i < n; i++) {
                str[i] = sc.next();
            }
            String key = sc.next();
            int key1 = sc.nextInt();
            Arrays.sort(str);
            int count = 0;
            char[] ch = key.toCharArray();
            Arrays.sort(ch);

            for(int i = 0; i < str.length; i++) {
                char[] ch1 = str[i].toCharArray();
                Arrays.sort(ch1);
                if (key.equals(str[i]))
                    continue;
                else if(Arrays.equals(ch, ch1)) {
                    count++;
                    list.add(str[i]);
                }
            }
            System.out.println(list.size());
            if(count >= key1)
                System.out.println(list.get(key1 - 1));
        }
    }
}
