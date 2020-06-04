import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SemaphoreDemo {
    private static final Semaphore semaphore = new Semaphore(4);
    private static final AtomicInteger nextId = new AtomicInteger(1);

    static class Player extends Thread {
        Player() {
            super(String.format("大玩家(%d)", nextId.getAndIncrement()));
        }

        @Override
        public void run() {
            try {
                System.out.println(new Date() + ":" + getName() + ": 我要租玩具");
                semaphore.acquire();
                System.out.println(new Date() + ":" + getName() + ": 我租到了玩具");
                TimeUnit.SECONDS.sleep(6);
                System.out.println(new Date() + ":" + getName() + ": 不玩，把玩具退回去");
                semaphore.release();
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Player player = new Player();
            player.start();
        }
    }
}