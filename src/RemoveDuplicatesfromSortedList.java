
public class RemoveDuplicatesfromSortedList {
	public ListNode2 deleteDuplicates(ListNode2 head) {
		if( head == null || head.next == null ) 
			return head;
		ListNode2 previous = head;
		ListNode2 current = head.next;
		while( current != null ) {
			if( previous.val == current.val ) {
				previous.next = current.next;
				current = current.next;
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		return head;		
	}	
}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}