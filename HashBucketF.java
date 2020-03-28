package 数据结构;

import java.util.Objects;

class  A {
    String name;
    int age;

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //需要重写equals和hashCode方法，调用IDEA的
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return age == a.age &&
                name.equals(a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class HashBucketF<K, V> {
    private static class Node<K,V>{
        private Node<K,V> next;
        private K key;
        private V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node<K,V>[]  array;
    private int size;

    public HashBucketF(){
        array = (Node<K, V>[]) new Node[10];
        size = 0;
    }

    public V get(K key){
        int idx = key.hashCode() % array.length;
        Node<K,V> cur = array[idx];
        while(cur != null){
            if(cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        //HashBucketT<A, A> hb;
        A a1 = new A("0", 10);
        A a2 = new A("0", 10);
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));

    }

}
