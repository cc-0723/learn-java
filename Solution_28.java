import java.util.*;

public class Main {
    public static void one(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(Integer in : arr) {
            int m = map.getOrDefault(in, 0);
            map.put(in, m + 1);
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            if(m.getValue() % 2 == 1) {
                System.out.print(m.getKey() + " ");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            one(arr);
        }
    }
}