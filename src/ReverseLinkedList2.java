
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if( head == null || m == n ) 
    		return head;
    	ListNode PreHead = new ListNode(Integer.MIN_VALUE);
    	PreHead.next = head;
    	head = PreHead;
    	int count = 0;
    	ListNode pre = null , p = head, PreMPtr = null, MPtr = null, NPtr = null;
    	
    	while( count <= n ) {
    		if( count == m - 1 )
    			PreMPtr = p;
    		else if( count == m )
    			MPtr = p;
    		else if( count == n )
    			NPtr = p;
    		ListNode tmp = p.next;
    		if( m < count && count <= n )
    			p.next = pre;
    		pre = p;
    		p = tmp;
    		count++;
    	}
    	
    	PreMPtr.next = NPtr;
    	MPtr.next = p;
    	return head.next;    	
    }
}
 