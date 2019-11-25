public class CopyList {
	public static Node copy(Node head) {
		Node nHead = null;
		Node nLast = null;
		Node cur = head;
		
		while(cur != null) {
			Node node = new Node(cur.val);
			if(nHead == null) {
				nHead = node;
			}else {
				nLast.next = node;
			}
			nLast = node;
			cur = cur.next;
		}
		return nHead;
	}
	
	
}