package 寒假练习;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/*
    插入排序：
    时间复杂度：O(n) ~ O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
     */

public class Solution_mySort {

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

    //向下调整
    public static void shitDownBig(int[] arr, int parent, int size) {
        int child = parent * 2 + 1;
        while(child <size) {
            if(child + 1 < size && arr[child + 1] > arr[child]) {
                child++;
            }
            if(arr[child] > arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    //堆排序
    /*
              堆排序：
              时间复杂度： O(n^2)
              稳定性：稳定
              空间复杂度：  常数空间  ---> O(1)
    */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        for(int i = (len / 2) + 2; i >=0; i--) {
            shitDownBig(arr,i,len);
        }
        //交换 + 向下调整
        //end是未排序的元素个数
        int end = len - 1;
        while(end > 0) {
            swap(arr,0,end);
            shitDownBig(arr,0,end);
            end--;
        }
    }

    //冒泡排序
    /*
              冒泡排序：
              时间复杂度：O(n) ~ O(n^2) 最好：顺序 + 标记   最坏：逆序
              稳定性：  稳定
              空间复杂度：  常数空间  ---> O(1)
    */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        while(len >0) {
            boolean flag = true;
            //一轮排序，排好一个元素
            for(int i = 0; i < len - 1; i++) {
                if(arr[i] > arr[ i + 1])
                    swap(arr, i, i + 1);
                flag = false;
            }
            if(flag)
                break;
            len--;
        }
    }

    //三数取中法
    public static int getMid(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if(arr[mid] > arr[left]) {
            if(arr[mid] < arr[right])
                return mid;
            else {
                if(arr[left] > arr[right])
                    return left;
                else
                    return right;
            }
        }else {
            if(arr[mid] > arr[right])
                return mid;
            else {
                if(arr[left] < arr[right])
                    return left;
                else
                    return right;
            }
        }
    }

    //霍尔法
    public static int partition1(int[] arr, int left, int right) {
        int key = left;
        int star = left;
        while(left < right) {
            //先从后向前找第一个小于key的数据，否则会出现错误
            while(left < right && arr[right] >= key) {
                right--;
            }
            while(left < right && arr[left] <= key) {
                left++;
            }
            swap(arr,left,right);
        }
        //把基准值和相遇的位置数据进行交换
        swap(arr,left,star);
        return left;
    }

    //挖坑法
    public static int partition2(int[] arr, int left, int right) {
        int key = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= key)
                right--;
            while(left < right && arr[left] <= key)
                left++;
            arr[right] = arr[left];
        }
        //基准值填到中间相遇的位置
        arr[left] = key;
        return left;
    }

    //前后遍历法
    public static int partition3(int[] arr, int left, int right) {
        //采用三数取中,解决栈溢出问题
        int mid = getMid(arr,left,right);
        swap(arr, left, mid);

        int key = arr[left];
        //prev最后一个小于key的位置
        int prev = left;
        //下一个小于key的位置
        int cur = left + 1;
        while(cur <= right) {
            if(arr[cur] < key && ++prev != cur)
                swap(arr, prev, cur);
            cur++;
        }
        swap(arr,left,prev);
        return prev;
    }

    //快速排序递归
    /*
              快速排序：
              时间复杂度：平均O(nlogn)  最坏O(n^2)数组本身就是有序的
              稳定性：  不稳定,交换基准值时可能交换相同元素的位置
              空间复杂度：  logn
     */
    public static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = partition3(arr, left, right);
            //分组
            quickSort(arr, left, mid - 1);
            quickSort(arr,mid + 1, right);
        }
    }

    //快排非递归
    public static void quickSortNoR(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        Stack<Integer> st = new Stack<>();
        if(left < right) {
            st.push(left);
            st.push(right);
        }
        while(!st.isEmpty()) {
            //取出栈顶的一对区间值
            int right1 = st.pop();
            int left1 = st.pop();
            int mid = partition3(arr, left1, right1);
            if(mid - 1 > left1) {
                st.push(left1);
                st.push(mid - 1);
            }
            if(mid + 1 < right1) {
                st.push(mid + 1);
                st.push(right1);
            }
        }
    }

    //归并排序
    /*
              归并排序：
              时间复杂度：O(nlogn)
              稳定性：  稳定
              空间复杂度：  O(n)
     */

    public static void mergeInternal(int[] arr, int left, int mid, int right, int[] tmp) {
        int begin1 = left, end1 = mid;
        int begin2 = mid + 1, end2 = right;
        int idx = left;
        while(begin1 <= end1 && begin2 <= end2) {
            //<=是稳定的，<是不稳定的
            if(arr[begin1] <= arr[begin2]) {
                //注意不能原地排序，会混乱数据元素
                tmp[idx++] = arr[begin1++];
            } else {
                tmp[idx++] = arr[begin2++];
            }
        }
        while(begin1 <= end1)
            tmp[idx++] = arr[begin1++];
        while (begin2 <= end2)
            tmp[idx++] = arr[begin2++];
        //拷贝
        for(int i = left; i <= right; i++)
            arr[i] = tmp[i];
    }

    public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if(left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid + 1, right, tmp);

        mergeInternal(arr, left, mid, right, tmp);
    }

    public static void merge(int[] arr) {
        //先开好辅助数组的大小
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0 ,arr.length - 1, tmp);
    }

    //非递归归并排序
    public static void mergeSortNoR(int[] arr) {
        int[] tmp = new int[arr.length];
        //i是每次归并的元素个数
        for(int i = 1; i < arr.length; i *= 2) {
            //j是下一次归并的开始位置
            for(int j = 0; j < arr.length; j += 2 * i) {
                int left = j;
                int mid = j + i - 1;
                //判断右半部分是否有数据
                if(mid >= arr.length - 1)
                    continue;
                int right = j + 2 * i - 1;
                //判断右边是否越界
                if(right >= arr.length) {
                    right = arr.length - 1;
                }
                mergeInternal(arr, left, mid, right, tmp);
            }
        }
    }

    public static void test() {
        int[] arr = {1,3,5,79,62,13,25,10,9,33,22};
        int[] copy = arr.clone();
        int[] copy2 = arr.clone();
        int[] copy3 = arr.clone();
        int[] copy4 = arr.clone();
        int[] copy5 = arr.clone();
        int[] copy6 = arr.clone();
        int[] copy7 = arr.clone();
        int[] copy8 = arr.clone();
        int[] copy9 = arr.clone();

        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("insertSort:" + Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println("Arrays.sort:" + Arrays.toString(copy));
        shellSort(copy2);
        System.out.println("shellSort:" + Arrays.toString(copy2));
        selectSort(copy3);
        System.out.println("selectSort:" + Arrays.toString(copy3));
        heapSort(copy4);
        System.out.println("heapSort:" + Arrays.toString(copy4));
        bubbleSort(copy5);
        System.out.println("bubbleSort:" + Arrays.toString(copy5));
        quickSort(copy6, 0, copy6.length - 1);
        System.out.println("quickSort:" + Arrays.toString(copy6));
        quickSortNoR(copy7);
        System.out.println("quickSortNoR:" + Arrays.toString(copy7));
        merge(copy8);
        System.out.println("mergeSort:" + Arrays.toString(copy8));
        mergeSortNoR(copy9);
        System.out.println("mergeSortNoR:" + Arrays.toString(copy9));
    }

    public static void test2() {
        Random ran = new Random(2020229130);
        int[] arr = new int[100000];
        for(int i = 0; i < 100000; i++) {
            arr[i] = ran.nextInt();
        }
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();
        int[] arr6 = arr.clone();
        int[] arr7 = arr.clone();

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

        begin = System.nanoTime();
        heapSort(arr4);
        end = System.nanoTime();
        System.out.printf("heapSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        bubbleSort(arr5);
        end = System.nanoTime();
        System.out.printf("bubbleSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        quickSort(arr6,0,arr6.length - 1);
        end = System.nanoTime();
        System.out.printf("quickSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        merge(arr7);
        end = System.nanoTime();
        System.out.printf("mergeSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

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

        begin = System.nanoTime();
        heapSort(arr4);
        end = System.nanoTime();
        System.out.printf("heapSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        bubbleSort(arr5);
        end = System.nanoTime();
        System.out.printf("bubbleSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        quickSort(arr6,0,arr6.length - 1);
        end = System.nanoTime();
        System.out.printf("quickSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        merge(arr7);
        end = System.nanoTime();
        System.out.printf("mergeSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

    }

    public static void main(String[] args) {
        //test2();
        test();
    }
}
