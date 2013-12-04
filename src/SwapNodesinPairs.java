
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    	if( head == null || head.next == null )
    		return head;
    	ListNode first = head;
    	ListNode second = head.next;
    	first.next = second.next;
    	second.next = first;
    	head = second;
    	ListNode previous = first;
    	while( first.next != null && first.next.next != null ) {
    		first = first.next;
    		second = first.next;
    		first.next = second.next;
        	second.next = first;
        	previous.next = second;
        	previous = first;
    	}
    	
    	return head;
    }
}
