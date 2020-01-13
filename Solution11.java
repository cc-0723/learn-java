package 寒假作业;

public class Solution11 {
    public static void main(String[] args) {
        System.out.println("value = " + switchit(4));
        //输出8，因为进入循环之后没有break，所以一直走完循环
    }

    public static int switchit(int x) {
        int j = 1;
        switch (x) {
            case 1: j++;
            case 2: j++;
            case 3: j++;
            case 4: j++;
            case 5: j++;
            default: j++;
        }
        return j + x;
    }
}
