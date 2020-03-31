package 二叉树;

import java.util.Arrays;

public class MyPriorityQueue {
    private int[] arr = new int[10];
    private int size;

    //入队
    public void offer(int value) {
        if(size == arr.length) {
            arr = Arrays.copyOf(arr,arr.length * 2);
        }
        //1.尾插
        //2.向上调整
        arr[size++] = value;
        MHeap.shitUpSmall(arr, size, size - 1);
    }

    //出队
    public int poll() {
        if(size > 0) {
            int peek = arr[0];
            MHeap.swap(arr, 0, size - 1);
            size--;
            MHeap.shiftDownSmall(arr, size, 0);
            return peek;
        }
        return -1;
    }

    public int peek() {
        return arr[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
