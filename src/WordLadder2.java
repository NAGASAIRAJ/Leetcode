import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder2 {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, 
													HashSet<String> dict) {
		HashMap<String, HashSet<String>> neighbors = new HashMap<String, HashSet<String>>();
		dict.add(start);
		dict.add(end);
		for( String s : dict ) 
			CalcNeighbors(neighbors, s, dict);
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		LinkedList<Node1> queue = new LinkedList<Node1>(); // BFS search queue
		queue.add(new Node1(null, start, 1));
		int PreLevel = 0;
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		
		while( !queue.isEmpty() ) {
			Node1 n = queue.pollFirst();
			if( end.equals(n.str) ) { // find a path, if longer than previous one, it's valid
				// otherwise all possible short path have been found, stop
				if( PreLevel == 0 || n.level == PreLevel ) {
					PreLevel = n.level;
					FindPath(n, res);
				}
				else 
					break; // all path with length PreLevel have been found
			}
			else {
				HashSet<String> set = neighbors.get(n.str);
				if( set == null || set.isEmpty() ) continue;
				ArrayList<String> ToRemove = new ArrayList<String>();
				for(String s : set) { // if s has been visited before a smaller level,
					// there is already a shorter path from start to s thus we should 
					// ignore s to break the infinite loop; if on the same level, put in queue
					if( visited.containsKey(s) ) {
						Integer OccurLevel = visited.get(s);
						if( n.level + 1 > OccurLevel ) {
							neighbors.get(s).remove(n.str);
							ToRemove.add(s);
							continue;
						}
					}
					visited.put(s,  n.level + 1);
					queue.add(new Node1(n, s, n.level + 1));
					if( neighbors.containsKey(s) )
						neighbors.get(s).remove(n.str);
				}
				for( String s : ToRemove )
					set.remove(s);
			}
		}
		return res;
	}
	private void FindPath(Node1 n, ArrayList<ArrayList<String>> res) {
		ArrayList<String> path = new ArrayList<String>();
		Node1 p = n;
		
		while( p != null ) {
			path.add(0, p.str);
			p = p.parent;
		}
		
		res.add(path);
	}
	private void CalcNeighbors(HashMap<String, HashSet<String>> neighbors, String s, 
								HashSet<String> dict) {
		// complexity : O(26 * s.length() * dict.size()) = O(L * N)
		int len = s.length();
		char[] chars = s.toCharArray();
		for( int i = 0; i < len; i++ ) {
			char old = chars[i];
			for( char c = 'a'; c <= 'z'; c++ ) {
				if( c == old )	continue;
				chars[i] = c;
				String NewStr = new String(chars);
				if( dict.contains(NewStr) ) {
					HashSet<String> set = neighbors.get(s);
					if( set != null )
						set.add(NewStr);
					else {
						HashSet<String> NewSet = new HashSet<String>();
						NewSet.add(NewStr);
						neighbors.put(s,  NewSet);
					}
				}
			}
			chars[i] = old;
		}
	}
}

class Node1 {
	public Node1 parent;
	public String str;
	public int level;
	public Node1(Node1 p, String s, int l) {
		parent = p;
		str = s;
		level = l;
	}
}