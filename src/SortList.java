
public class SortList {
	public ListNode sortList(ListNode head) {				
		return MergeSortList(head);			
    }
	private ListNode MergeSortList(ListNode head) {
		if( head == null || head.next == null )	
			return head;
		
		ListNode fast = head, slow = head;
	   	 
    	while( fast.next != null && fast.next.next != null ) {
    		fast = fast.next.next;
    		slow = slow.next;	
    	}
    	
    	ListNode p1 = head, p2 = slow.next;
    	slow.next = null; // break from middle
    	
    	ListNode h1 = MergeSortList(p1);
    	ListNode h2 = MergeSortList(p2);
    	
    	return MergeTwoList(h1, h2); 
	}
	
	private ListNode MergeTwoList(ListNode p1, ListNode p2) {
    	if( p2 == null )	return p1;
    	if( p1 == null )	return p2;
    	ListNode FakeHead = new ListNode(Integer.MIN_VALUE);
    	ListNode PointerRes = FakeHead;    	    	    	
		
		ListNode p1_tmp = p1, p2_tmp = p2;						
    	
    	while( p1_tmp != null && p2_tmp != null ) {
    		if( p1_tmp.val < p2_tmp.val ) {
    			PointerRes.next = p1_tmp;    			
    			p1_tmp = p1_tmp.next;
    		}
    		else {
    			PointerRes.next = p2_tmp;
    			p2_tmp = p2_tmp.next;
    		}
    		PointerRes = PointerRes.next;
    	}
    	
    	while( p1_tmp != null ) {
    		PointerRes.next = p1_tmp;
    		p1_tmp = p1_tmp.next;
    		PointerRes = PointerRes.next;
    	}
    	
    	while( p2_tmp != null ) {
    		PointerRes.next = p2_tmp;
    		p2_tmp = p2_tmp.next;
    		PointerRes = PointerRes.next;
    	}
    	 	
    	return FakeHead.next;
    }
}
