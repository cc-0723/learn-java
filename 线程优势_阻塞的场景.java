package 多线程;

import java.util.Scanner;

public class 线程优势_阻塞的场景 {
    public static int fib(int n) {
        if(n < 2){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static class FibThread extends Thread {
        private int n;

        FibThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            System.out.println(fib(n));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt();
            //System.out.println(fib(n));
            FibThread thread = new FibThread(n);
            thread.start();
        }
    }
}
