package 练习;

import java.util.HashMap;
import java.util.Map;

public class Solution_12 {
    //复制随机指针
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> mp = new HashMap<>();
        Node newH = null, newT = null;
        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val);
            if(newH == null) {
                newH = newT = node;
            } else {
                newT.next = node;
                newT = newT.next;
            }
            mp.put(cur,node);
            cur = cur.next;
        }
        //构件随机指针
        cur = head;
        newT = newH;
        while(cur != null) {
            if(cur.random != null) {
                newT.random = mp.get(cur.random);
            } else {
                newT.random = null;
            }
            cur = cur.next;
            newT = newT.next;
        }
        return newH;
    }
}
