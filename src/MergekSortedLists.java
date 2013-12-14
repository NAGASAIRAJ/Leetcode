import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergekSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if( lists == null || lists.size() == 0 )
			return null;
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			public int compare(ListNode m, ListNode n) {
				if( m.val == n.val )	return 0;
				else if( m.val > n.val )
					return 1;
				return -1;
			}
		};
		
		PriorityQueue<ListNode> PQ = new PriorityQueue<ListNode>(lists.size(), comparator);
		for( int i = 0; i < lists.size(); i++ ) {
			if( lists.get(i) != null )
				PQ.add(lists.get(i));
		}
		ListNode head = null, cur = null;
		while( !PQ.isEmpty() ) {
			if( head == null ) {
				head = PQ.poll();
				cur = head;
			}
			else {
				cur.next = PQ.poll();
				cur = cur.next;
			}
			if( cur.next != null )
				PQ.add(cur.next);
		}
			
		return head;		
	}
}
