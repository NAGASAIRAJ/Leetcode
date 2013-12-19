import java.util.HashMap;


public class CopyListwithRandomPointer {
	 public RandomListNode copyRandomList(RandomListNode head) {
		 if( head == null )	return head;
		 HashMap<RandomListNode, RandomListNode> NodeMap = new HashMap<RandomListNode, RandomListNode>();
		 RandomListNode pointer = head;
		 
		 while( pointer != null ) {
			 RandomListNode node = new RandomListNode(pointer.label);
			 NodeMap.put(pointer, node);
			 pointer = pointer.next;
		 }
		 
		 pointer = head;
		 
		 while( pointer != null ) {
			 RandomListNode node = NodeMap.get(pointer);
			 node.next = null;
			 node.random = null;
			 if( pointer.next != null )
				 node.next = NodeMap.get(pointer.next);
			 if( pointer.random != null )
				 node.random = NodeMap.get(pointer.random);
			 pointer = pointer.next;
		 }
		 
		 return NodeMap.get(head);
	 }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
