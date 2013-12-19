import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class CloneGraph {
	Map<Integer, UndirectedGraphNode> NodeMap = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if( node == null )	return null;
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		NodeMap.clear();
		Set<Integer> IsFound = new HashSet<Integer>();
		UndirectedGraphNode head = null;
		queue.add(node);
				
		while( !queue.isEmpty() ) {
			UndirectedGraphNode cur = queue.getFirst();
			queue.removeFirst();
			UndirectedGraphNode NewNode = NodeMap.get(cur.label);
			if( NewNode == null ) {
				NewNode = new UndirectedGraphNode(cur.label);
				NodeMap.put(cur.label, NewNode);
			}
			if( head == null )
				head = NewNode;
			if( !IsFound.contains(cur.label) ) {
				IsFound.add(cur.label);
				for( int i = 0; i < cur.neighbors.size(); i++ ) {
					UndirectedGraphNode neighbor = cur.neighbors.get(i);
					UndirectedGraphNode NewNeighbor = NodeMap.get(neighbor.label);
					if( NewNeighbor == null ) {
						NewNeighbor = new UndirectedGraphNode(neighbor.label);
						NodeMap.put(neighbor.label, NewNeighbor);
						queue.addLast(neighbor);
					}
					NewNode.neighbors.add(NewNeighbor);
				}
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
