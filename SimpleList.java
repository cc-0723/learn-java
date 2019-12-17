package Java_SE;

public class SimpleList {
    public static class ListNode {
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode node = new ListNode();
        //头插
        node.val = 1;
        node.next = head;
        head = node;
        //打印
        for(ListNode c = head; c != null; c = c.next) {
            System.out.println(c.val);
        }
        System.out.println("-------");

        //尾插
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new ListNode();
        last.next.val = 2;
        for(ListNode c = head; c != null; c = c.next) {
            System.out.println(c.val);
        }
        System.out.println("-------");

        //复制
        ListNode result = null;
        ListNode nLast = null;
        for(ListNode c = head; c != null; c = c.next) {
            ListNode nNode = new ListNode();
            nNode.val = c.val;
            if(result == null) {
                result = nNode;
            }else {
                nLast.next = nNode;
            }
            nLast = nNode;
        }
        for(ListNode c = head; c != null; c = c.next) {
            System.out.println(c.val);
        }

    }
}
