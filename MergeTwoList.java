import jdk.nashorn.internal.ir.CallNode;
import jdk.nashorn.internal.parser.JSONParser;

public class MergeTwoList {
    private static Node mergeTwoList(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        //定义了来个引用，用来遍历链表
        Node cur1 = list1;
        Node cur2 = list2;

        Node nHead = null;
        Node nLast = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                if (nHead == null) {
                    nHead = cur1;
                } else {
                    nLast.next = cur1;
                }
                nLast = cur1;

                cur1 = cur1.next;
            } else {
                if (nHead == null) {
                    nHead = cur2;
                } else {
                    nLast.next = cur2;
                }
                nLast = cur2;
                cur2 = cur2.next;
            }
        }

        if (cur1 != null) {
            nLast.next = cur1;
        } else {
            nLast.next = cur2;
        }

        return nHead;
    }

    public static void main(String[] args) {
        Node n5 = new Node(5,null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);//1 2 3 4 5

        Node m3 = new Node(13,null);
        Node m2 = new Node(7, m3);
        Node m1 = new Node(0, m2);//0 7 13

        Node result = mergeTwoList(n1, m1);
        printList(result);
    }

    private static void printList(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur);
        }
    }
}
