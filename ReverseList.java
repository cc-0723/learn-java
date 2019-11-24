public class ReverseList {
    public Node reverseList(Node head) {
        Node cur = head;
        Node nHead = null;
        while(cur != null) {
            Node next = cur.next;
            cur.next = nHead;
            nHead = cur;
            cur = next;
        }
        return nHead;
    }

    public static Node buildList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;
    }

    public static void main(String[] args) {
        Node head = buildList();
        ReverseList object = new ReverseList();
        Node rHead = object.reverseList(head);

        printList(rHead);
    }

    private static void printList(Node head) {
        for(Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur);
        }
    }
}
