package 排序;

import java.util.Arrays;
import java.util.Random;

/*
    插入排序：
    时间复杂度：O(n) ~ O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
     */

public class MySort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            //i是已经排好序列的最后一个元素
            int key = arr[i + 1];
            int end = i;
            while(end >= 0 && arr[end] > key) {
                //把大的元素向后移动
                arr[end + 1] = arr[end];
                end--;
            }
            arr[end + 1] = key;
        }
    }

    //希尔排序
    //不是一组数据排序完之后才排第二组的，而是i++，循环交替排序每一组数据

    /*
    希尔排序：改善的插入排序
    时间复杂度：大概是O(1.3)
    空间复杂度：O(1)
    稳定性：不稳定
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while(gap > 1) {
            gap = gap / 3 + 1;
            for(int i = 0; i < arr.length - gap; i++) {
                int end = i;
                int key = arr[i + gap];
                while(end >= 0 && arr[end] > key) {
                    arr[end + gap] = arr[end];
                    end -= gap;
                }
                arr[end + gap] = key;
            }
        }
    }

      /*
              选择排序：
              时间复杂度： O(n^2)
              稳定性：可以让它稳定/不稳定
              空间复杂度：  常数空间  ---> O(1)
    */
    public static void selectSort(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end) {
            int min = begin;
            int max = begin;
            for(int i = begin; i <= end; i++) {
                if(arr[i] < arr[min])
                    min = i;
                if(arr[i] > arr[max])
                    max = i;
            }
            swap(arr,begin,min);
            if(max == begin)
                max = min;
            swap(arr,end,max);
            begin++;
            end--;
        }
    }

    public static void selectSort2(int[] arr){
        //i: 未排序的最大位置
        for(int i = arr.length - 1; i > 0; --i)
        {
            int end = i;
            int maxIdx = i;
            //从所有未排序的数据中找最大值的索引
            for(int j = end - 1; j >=0; --j){
                if(arr[j] >arr[maxIdx])
                    maxIdx = j;
            }
            swap(arr, maxIdx, end);
        }
    }

    public static void test() {
        int[] arr = {1,3,5,79,62,13,25,10,9,33,22};
        int[] copy = arr.clone();
        int[] copy2 = arr.clone();
        int[] copy3 = arr.clone();
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        shellSort(copy2);
        System.out.println(Arrays.toString(copy2));
        selectSort(copy3);
        System.out.println(Arrays.toString(copy3));
    }

    public static void test2() {
        Random ran = new Random(2020229130);
        int[] arr = new int[100000];
        for(int i = 0; i < 100000; i++) {
            arr[i] = ran.nextInt();
        }
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();

        long begin = System.nanoTime();
        insertSort(arr);
        long end = System.nanoTime();
        System.out.printf("insertSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        shellSort(arr2);
        end = System.nanoTime();
        System.out.printf("shellSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        System.out.println("数据已经有序： ");
        begin = System.nanoTime();
        insertSort(arr);
        end = System.nanoTime();
        System.out.printf("insertSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        shellSort(arr2);
        end = System.nanoTime();
        System.out.printf("shellSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);
    }

    public static void main(String[] args) {
        test2();
    }
}
