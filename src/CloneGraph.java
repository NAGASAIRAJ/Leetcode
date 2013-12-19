import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if( node == null )	return null;
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Map<Integer, UndirectedGraphNode> hashmap = new HashMap<Integer, UndirectedGraphNode>();
		UndirectedGraphNode head = node;
		queue.add(head);
		hashmap.put(node.label, head);
		
		while( !queue.isEmpty() ) {
			UndirectedGraphNode cur = queue.getFirst();
			queue.removeFirst();
			for( int i = 0; i < cur.neighbors.size(); i++ ) {
				UndirectedGraphNode neighbor = cur.neighbors.get(i);
				if( !hashmap.containsKey(neighbor.label) ) {
					UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
					hashmap.put(neighbor.label, tmp);
					queue.addLast(neighbor);
				}
				cur.neighbors.add(neighbor);
			}
		}
		
		return head;
    }
}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
