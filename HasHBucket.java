package 数据结构;
public class HasHBucket {
    //哈希表
    public static class Node {
        int value;
        int key;
        Node next = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private Node[] arr;
    private int size;
    private static final double LOAD_FACTORY = 0.7;

    public void HasHBucket() {
        arr = new Node[10];
        size = 0;
    }

    //负载因子
    public double loadFactory() {
        return size * 1.0 / arr.length;
    }

    public int put(int key, int value) {
        if(loadFactory() >= LOAD_FACTORY) {
            resize();
        }
        int idx = key % arr.length;
        //不能插入相同的元素
        Node cur = arr[idx];
        while(cur != null) {
            if(cur.key == key) {
                int oldV = cur.value;
                cur.value = value;
                return oldV;
            }
            cur = cur.next;
        }
        //插入
        cur = new Node(key, value);
        cur.next = arr[idx];
        arr[idx] = cur;

        size++;
        return -1;
    }

    public void resize() {
        Node[] newArray = new Node[arr.length * 2];
        //元素搬移
        // 遍历旧表
        for(int i = 0; i < arr.length; ++i){
            Node curHead = arr[i];
            while(curHead != null){
                Node next = curHead.next;

                //计算当前元素在新表中的位置
                int idx = curHead.key % newArray.length;
                //头插
                curHead.next = newArray[idx];
                newArray[idx] = curHead;

                curHead = next;

            }
        }
        arr = newArray;
    }

    public void printHashBuket(){
        for(int i = 0; i < arr.length; ++i){
            Node cur = arr[i];
            while(cur != null){
                System.out.print(cur.key + "-->" + cur.value + "\t");
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public int get(int key) {
        int idx = key % arr.length;
        Node cur = arr[idx];
        while(cur != null) {
            if(key == cur.key)
                return cur.key;
            cur = cur.next;
        }
        return -1;
    }

    public int remove(int key){
        // 平均时间复杂度： O(1)
        int idx = key % arr.length;
        Node prev = null;
        Node cur = arr[idx];
        //单链表的删除
        while(cur != null){
            if(cur.key == key){
                //删除的是头结点
                if(prev == null)
                    arr[idx] = cur.next;
                    //不是头结点
                else
                    prev.next = cur.next;

                return cur.value;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HasHBucket hb = new HasHBucket();
        hb.put(1,1);
        hb.put(2,2);
        hb.put(3,3);
        hb.put(4,4);
        hb.put(5,5);
        hb.put(6,6);
        hb.put(1, -1);
        hb.put(2, -2);
        hb.printHashBuket();
        System.out.println(hb.get(1));
        System.out.println(hb.get(6));
        System.out.println(hb.remove(5));
        hb.printHashBuket();
        System.out.println(hb.remove(3));
        hb.printHashBuket();
        System.out.println(hb.remove(100));
        hb.printHashBuket();
    }

}


