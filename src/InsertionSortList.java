
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
    	if( head == null )	return head;
    	ListNode TmpHead = new ListNode(0);
    	ListNode NewList = TmpHead, OldList = head;
    	
    	while( OldList != null ) {
    		ListNode pre = FindInsertPosition(NewList, OldList);
    		ListNode OldNext = OldList.next;
    		OldList.next = pre.next;
    		pre.next = OldList;
    		OldList = OldNext;
    	}
    	
    	return TmpHead.next;    
    }    
    private ListNode FindInsertPosition(ListNode NewList, ListNode OldList) {
    	ListNode pre = null, cur = NewList;
    	
    	while( cur != null && cur.val <= OldList.val ) {
    		pre = cur;
    		cur = cur.next;
    	}
    	
    	return pre;
    }
}
