
public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if( head == null || k == 1 )
			return head;
		int len = 0;
		ListNode it = head;
		
		while( it != null ) {
			len++;
			it = it.next;
		}
		
		ListNode FakeHead = new ListNode(-1);
		FakeHead.next = head;
		ListNode pre = FakeHead, cur = head, post = head.next;
		for( int i = 0 ; i < len / k; i++ ) {
			post = cur.next;
			int j = 0;
			
			while( post != null ) {
				ListNode tmp = post.next;
				post.next = cur;
				cur = post;
				post = tmp;
				j++;
				if( j == k - 1 )
					break;
			}
			
			ListNode tmp = pre.next;
			pre.next = cur;
			tmp.next = post;
			pre = tmp;	
			cur = pre.next;			
		}
		return FakeHead.next;
	}
}
