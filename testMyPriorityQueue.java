package 二叉树;

import java.util.PriorityQueue;

public class testMyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.offer(9);
        p.offer(2);
        p.offer(10);
        p.offer(15);
        p.offer(3);
        p.offer(1);
        p.offer(7);
        p.offer(23);
        p.offer(89);
        while(!p.isEmpty()) {
            System.out.print(p.poll() + " ");
        }
        System.out.println();
        System.out.println("My:");

        MyPriorityQueue pq = new MyPriorityQueue();
        pq.offer(9);
        pq.offer(2);
        pq.offer(10);
        pq.offer(15);
        pq.offer(3);
        pq.offer(1);
        pq.offer(7);
        pq.offer(23);
        pq.offer(89);
        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

    }
}
