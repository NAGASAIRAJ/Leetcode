
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if( head == null || n == 0 )	return head;
		int len = 1;
		ListNode it = head;
		
		while( it.next != null ) {
			len++;
			it = it.next;
		}
		
		it.next = head;
		int start = (len - n) % len;
		
		while( start < 0 ) {
			start += len;
			start %= len;
		}
				
		while( start > 0 ) {
			it = it.next;
			start--;
		}
		
		head = it.next;
		it.next = null;
		
		return head;
    }
}
