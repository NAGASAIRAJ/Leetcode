
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	if( head == null || head.next == null )
    		return false;
    	ListNode slow = head;
    	ListNode fast = head;
    	while( fast != null && fast.next != null ) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if( slow == fast )
    			return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		
		if( hasCycle(head))
			System.out.println("Linked List has cycle!");
		else
			System.out.println("Linked List has no cycle!");
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
