package Java_SE;

public class ComplexList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode random;
    }

    static ListNode copy(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur;
        cur = head;
        while (cur != null) {
            ListNode nNode = new ListNode();
            nNode.val = cur.val;
            //每次循环，创建一个新节点，然后把新节点和旧节点串起来
            nNode.next = cur.next;
            cur.next = nNode;
            cur = nNode.next;
        }

        //拷贝random
        cur = head;
        while (cur != null) {
            ListNode nNode = cur.next;
            if(cur.random != null) {
                nNode.random = cur.random.next;
            }
            cur = nNode.next;
        }

        //把新节点所成的链表从原来串起来的链表上取出来，返回新的链表
        cur = head;
        ListNode result = head.next;
        while (cur != null) {
            ListNode nNode = cur.next;
            cur.next = nNode.next;
            if(nNode.next != null) {
                nNode.next = nNode.next.next;
            }
            cur = cur.next;
        }
        return result;
    }
}
