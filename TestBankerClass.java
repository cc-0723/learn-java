package MyWork;

import java.util.Scanner;

public class TestBankerClass {
    public static void main(String[] args) {
        boolean Choose = true;
        String C;
        Scanner in = new Scanner(System.in);
        BankerClass T = new BankerClass();
        System.out.println("这是一个三个进程，初始系统可用三类资源为{10,8,7}的银行家算法：");

        T.setSystemVariable();
        while (Choose == true) {
            T.setRequest();
            System.out.println("您是否还要进行请求：yes or no?");
            C = in.nextLine();
            if (C.endsWith("no")) {
                Choose = false;
            }
            System.out.println("请求结束！");
        }
    }
}
//进程的最大资源需求量：857,525,662
//分配资源：320,202,132
//请求0号，请求100
//yes, 2号，010