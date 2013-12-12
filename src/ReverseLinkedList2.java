
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if( head == null || m == n ) 
    		return head;
    	ListNode PreHead = new ListNode(Integer.MIN_VALUE);
    	PreHead.next = head;
    	head = PreHead;
    	int count = 0;
    	ListNode pre = null , cur = head, PreMPtr = null, MPtr = null, NPtr = null;
    	
    	while( count <= n ) {
    		if( count == m - 1 )
    			PreMPtr = cur;
    		else if( count == m )
    			MPtr = cur;
    		else if( count == n )
    			NPtr = cur;
    		ListNode tmp = cur.next;
    		if( m < count && count <= n )
    			cur.next = pre;
    		pre = cur;
    		cur = tmp;
    		count++;
    	}
    	
    	PreMPtr.next = NPtr;
    	MPtr.next = cur;
    	return head.next;    	
    }
}
 