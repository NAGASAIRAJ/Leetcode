
public class RemoveDuplicatesfromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
    	if( head == null )	return head;
    	ListNode FakeHead = new ListNode(Integer.MIN_VALUE);
    	FakeHead.next = head;
    	head = FakeHead;
    	ListNode pre = head, cur = head.next;
    	
    	while( cur != null ) {
    		boolean CurDuplicated = false;
    		while( cur != null && cur.next != null ) {
    			if( cur.val == cur.next.val ) {
    				cur.next = cur.next.next;
    				CurDuplicated = true;
    			}
    			else 
    				break;    			
    		}
    		if( CurDuplicated ) {
    			pre.next = cur.next;
    			cur = pre.next;
    			continue;
    		}
    		pre = cur;
    		cur = cur.next;
    	}
    	
    	return head.next;    		
    }
}
