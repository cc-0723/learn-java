package 多线程;

import java.util.concurrent.TimeUnit;

public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
        System.out.println(end - start);

    }
}
