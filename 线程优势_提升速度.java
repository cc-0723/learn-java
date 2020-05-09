package 多线程;

public class 线程优势_提升速度 {
    private static final long count = 1000000000;
    private static final int n = 10;

    private static void cal() {
        long r = 0;
        for(long i = 0; i < count; i++) {
            r += i;
        }
        System.out.println(r);
    }

    private static class CalcThread extends Thread {
        @Override
        public void run() {
            cal();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        CalcThread[] threads = new CalcThread[n - 1];

        for(int i = 0; i < n - 1; i++) {
            //创建N- 1 个线程，每个线程都计算一次
            CalcThread thread = new CalcThread();
            thread.start();
            threads[i] = thread;
        }
        //剩下的一个放到主线程中计算
        cal();

        for(int i = 0; i < n -1; i++) {
            threads[i].join();//阻塞到这个方法上
        }

        //此时代表所有的线程都运行结束了
        long end = System.nanoTime();
        double 耗时ms = (end - start) * 1.0 / 1000 / 1000;
        System.out.println("耗时：" + 耗时ms);

        /*
        long start = System.nanoTime();
        for(int i = 0; i < n; i++) {
            cal();
        }
        long end = System.nanoTime();
        double 耗时ms = (end - start) * 1.0 / 1000 / 1000;
        System.out.println("耗时：" + 耗时ms);
    }

         */
    }
}

