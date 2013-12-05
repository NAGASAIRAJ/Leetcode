
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if( head == null ) {
    		if( n == 0 )
    			return head;
    	}
    	if( head.next == null ) {
    		if( n == 1 )
    			head = null;
    		return head;
    	}    	
    	ListNode EndPointer = head.next;
    	ListNode Pre = new ListNode(-1); 
    	Pre.next = head;
    	ListNode Cur = head;
    	int DistanceToEnd = 0;
    	while( EndPointer != null ) {
    		if( DistanceToEnd == n ) {
    			Pre = Cur;
    			Cur = Cur.next;
    		}
    		else 
    			DistanceToEnd++;
    		EndPointer = EndPointer.next;    		
    	}
    	if( Cur == head ) 
			head = Cur.next;
		else
			Pre.next = Cur.next;
		return head;
    }
}
