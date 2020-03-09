package 二叉树;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MHeap {
    public  static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //大堆向下调整
    public static void shiftDownBig(int[] arr, int size, int parent) {
        //左孩子
        int child = 2 * parent + 1;
        while(child < size) {
            //从两个孩子中选一个最大的
            if(child + 1 < size && arr[child + 1] > arr[child]) {
                child++;
            }
            //孩子节点大于父节点，向下调整
            if(arr[child] > arr[parent]) {
                swap(arr,child,parent);
                //更新，继续向下调整
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    //小堆向下调整
    public static void shiftDownSmall(int[] arr, int size, int parent) {
        //左孩子
        int child = 2 * parent + 1;
        while(child < size) {
            //从两个孩子中选一个最小的
            if(child + 1 < size && arr[child + 1] < arr[child]) {
                child++;
            }
            //孩子节点小于父节点，向下调整
            if(arr[child] < arr[parent]) {
                swap(arr,child,parent);
                //更新，继续向下调整
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public static  void createHeapBig(int[] arr) {
        //从最后一个非叶子节点向下调整
        for(int i = (arr.length - 2) / 2; i >= 0; i--) {
            shiftDownBig(arr, arr.length, i);
        }
    }

    public static  void createHeapSmall(int[] arr) {
        //从最后一个非叶子节点向下调整
        for(int i = (arr.length - 2) / 2; i >= 0; i--) {
            shiftDownSmall(arr, arr.length, i);
        }
    }

    public static void shitUpBig(int[] arr, int size, int child) {
        int parent = (child - 1) / 2;
        while(child > 0) {
            if(arr[child] > arr[parent]) {
                swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public static void shitUpSmall(int[] arr, int size, int child) {
        int parent = (child - 1) / 2;
        while(child > 0) {
            if(arr[child] < arr[parent]) {
                swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 10, 15, 3 , 1, 7, 23, 89};
        //复制数组内容
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        createHeapBig(arr);
        System.out.println(Arrays.toString(arr));
        createHeapSmall(arr);
        System.out.println(Arrays.toString(copy));

        //优先级队列
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
    }

}
