
public class MergeTwoSortedLists {
    public ListNode3 mergeTwoLists(ListNode3 l1, ListNode3 l2) {
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;
        ListNode3 head = new ListNode3(0);
        ListNode3 cur = head;
        while( l1 != null && l2 != null ) {
        	if( l1.val < l2. val ) {
        		cur.next = l1;
        		l1 = l1.next;
        	}
        	else {
        		cur.next = l2;
        		l2 = l2.next;
        	}
        	cur = cur.next;
        }
        if( l1 == null ) cur.next = l2;
        else cur.next = l1;
        return head.next;                
    }
}

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) {
        val = x;
        next = null;
    }
}
