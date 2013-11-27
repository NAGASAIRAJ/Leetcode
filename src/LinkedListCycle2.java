
public class LinkedListCycle2 {
    public static ListNode1 detectCycle(ListNode1 head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	if( head == null || head.next == null )
    		return null;
    	ListNode1 slow = head;
    	ListNode1 fast = head;
    	while( fast != null && fast.next != null ) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if( slow == fast ) {
    			slow = head;
    			while( slow != fast ) {
    				slow = slow.next;
    				fast = fast.next;
    			}
    			return fast;	
    		}    			
    	}
    	return null;
    }
    
	public static void main(String[] args) {
		ListNode1 head = new ListNode1(1);
		head.next = new ListNode1(2);
		head.next.next = new ListNode1(3);
		head.next.next.next = new ListNode1(4);
		head.next.next.next.next = new ListNode1(5);
		head.next.next.next.next.next = new ListNode1(6);
		head.next.next.next.next.next.next = head.next.next;
		
		ListNode1 result = detectCycle(head);
		if( result != null )
			System.out.println("Linked List has cycle start at " + result.val);
		else
			System.out.println("Linked List has no cycle!");
	}
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}
