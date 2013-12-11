
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode ln = new ListNode(Integer.MIN_VALUE);
		ln.next = head;
		head = ln;
		ListNode pre = null;
		
		while( ln != null && ln.val < x ) {
			pre = ln;
			ln = ln.next;			
		}
				
		if( ln != null ) {
			ListNode cur = pre;
			while( ln != null ) {
				if( ln.val < x ) {
					pre.next = ln.next;
					ListNode tmp = cur.next;
					cur.next = ln;
					ln.next = tmp;
					cur = cur.next;
					ln = pre;
				}
				pre = ln;
				ln = ln.next;
			}
		}
		return head.next;
    }
}
