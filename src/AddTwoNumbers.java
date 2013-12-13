
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if( l1 == null )	return l2;
    	if( l2 == null )	return l1;
    	ListNode L1It = l1, L2It = l2;
    	int carry = 0;
    	ListNode FakeHead = new ListNode(-1);
    	ListNode CurNode = FakeHead;
    	
    	while( L1It != null && L2It != null ) {
    		int NodeVal = (L1It.val + L2It.val + carry) % 10;
    		carry = (L1It.val + L2It.val + carry) / 10;
    		ListNode TmpNode = new ListNode(NodeVal);
    		CurNode.next = TmpNode;
    		CurNode = CurNode.next;
    		L1It = L1It.next;
    		L2It = L2It.next;
    	}
    	
    	if( L1It != null ) {
    		while( L1It != null ) {
    			int NodeVal = (L1It.val + carry) % 10;
        		carry = (L1It.val + carry) / 10;
        		ListNode TmpNode = new ListNode(NodeVal);
        		CurNode.next = TmpNode;
        		CurNode = CurNode.next;
        		L1It = L1It.next;
    		}
    	}
    	else if( L2It != null ) {
    		while( L2It != null ) {
    			int NodeVal = (L2It.val + carry) % 10;
        		carry = (L2It.val + carry) / 10;
        		ListNode TmpNode = new ListNode(NodeVal);
        		CurNode.next = TmpNode;
        		CurNode = CurNode.next;
        		L2It = L2It.next;
    		}
    	}
    	
    	if( carry > 0) {
    		ListNode TmpNode = new ListNode(carry);
    		CurNode.next = TmpNode;
    	}
    	
    	return FakeHead.next;
    }
}
