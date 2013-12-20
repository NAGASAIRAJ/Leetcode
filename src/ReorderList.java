
public class ReorderList {
    public void reorderList(ListNode head) {
    	if( head == null )	return;
    	ListNode fast = head, slow = head;
    	 
    	while( fast.next != null && fast.next.next != null ) {
    		fast = fast.next.next;
    		slow = slow.next;	
    	}
    	
    	ListNode p1 = head, p2 = slow.next;
    	slow.next = null; // break from middle
    	p2 = ReverseList(p2);
    	MergeTwoList(head, p1, p2);
    }
    private void MergeTwoList(ListNode head, ListNode p1, ListNode p2) {
    	if( p2 == null )	return;
    	head = new ListNode(-1);
    	ListNode PointerRes = head;
    	int count = 0;
    	
    	while( p1 != null && p2 != null ) {
    		if( count % 2 == 0 ) {
    			PointerRes.next = p1;    			
    			p1 = p1.next;
    		}
    		else {
    			PointerRes.next = p2;
    			p2 = p2.next;
    		}
    		PointerRes = PointerRes.next;
    		count++;
    	}
    	
    	while( p1 != null ) {
    		PointerRes.next = p1;
    		p1 = p1.next;
    		PointerRes = PointerRes.next;
    	}
    	
    	while( p2 != null ) {
    		PointerRes.next = p2;
    		p2 = p2.next;
    		PointerRes = PointerRes.next;
    	}
    	
    	head = head.next;
    }
    private ListNode ReverseList(ListNode head) {
    	if( head == null || head.next == null )
    		return head;
    	ListNode cur = head.next, pre = head;
    	ListNode tmp = null;
    	pre.next = null;
    	
    	while( cur != null ) {
    		tmp = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = tmp;
    	}
    	
    	return pre;
    }
}
