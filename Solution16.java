package 寒假作业;

public class Solution16 {
    //长建按入
    public boolean isLongPressedName(String name, String typed) {
        char [] c1 = name.toCharArray();
        char [] c2 = typed.toCharArray();
        int p1 = 0, p2 = 0;

        while(p1 < c1.length && p2 < c2.length) {
            if(c1[p1] == c2[p2]) {
                p1++;
            }
            p2++;
        }
        return p1 == c1.length;
    }
}
