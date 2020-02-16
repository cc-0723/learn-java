public class PalindromeList {
	 
	 //求长度
	public int getLength(ListNode head) {
		int count =0;
		ListNode cur = head;
		while(cur != null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
	
	//求中位数
	public ListNode getMiddle(ListNode head) {
		int length = getLength(head);
		int half = length / 2;
		ListNode cur = head;
		for(int i = 0; i < half; i ++){
			cur = cur.next;
		}
		return cur;
	}
	
	//逆置链表
	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode nHead =null;
		ListNode next =cur.enxt;
		while(cur != null) {
			cur.next = nHead;
			nHead = cur;
			cur = next;
		}
		return nHead;
	}
	
	//判断是否是回文
	public boolean chkPalindrome(ListNode A) {
		ListNode middle = getMiddle(A);
		ListNode rHead = reverseList(middle);
		ListNode c1 = A;
		ListNode c2 = rHead;
		while(c1 != null && c2 != null) { 
			if(c1.val != c2.val) {
				return false;
			}
			c1 = c1.next;
			c2 = c2.next;
		}
		return true;
	}

}