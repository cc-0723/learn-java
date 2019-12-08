package 数据结构;

import java.util.Arrays;

public class Stack {            //顺序表实现栈
    private int array[];
    private int size;

    public Stack(int n) {
        size = 0;
        array = new int[n];
    }

    public void push(int value) {
        if(size == array.length) {
            array = Arrays.copyOf(array,2 * size);        //扩容
        }
        array[size++] = value;
    }

    public void pop() {
        if(size > 0)
            size --;
    }

    public int peek() {
        return array[size - 1];
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack st = new Stack(2);
        System.out.println(st.size());
        System.out.println(st.empty());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.size());
        System.out.println(st.empty());
        while (!st.empty()) {
            System.out.println("栈顶元素为" + st.peek());
            st.pop();
        }
        System.out.println(st.size());
        System.out.println(st.empty());
    }

}

