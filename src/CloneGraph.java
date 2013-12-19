import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if( node == null )	return null;
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> hashmap = new HashMap<UndirectedGraphNode, 
																		UndirectedGraphNode>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		queue.add(head);
		hashmap.put(node, head);
		
		while( !queue.isEmpty() ) {
			UndirectedGraphNode cur = queue.pollFirst();
			for( int i = 0; i < cur.neighbors.size(); i++ ) {
				UndirectedGraphNode neighbor = cur.neighbors.get(i);
				if( !hashmap.containsKey(neighbor) ) {
					UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
					hashmap.get(cur).neighbors.add(tmp);
					hashmap.put(neighbor, tmp);
					queue.addLast(neighbor);
				}
				else
					hashmap.get(cur).neighbors.add(hashmap.get(neighbor));
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
