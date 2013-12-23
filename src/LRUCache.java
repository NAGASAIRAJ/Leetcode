import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class LRUCache {
	private int capacity;
	private Map<Integer, Entry> nodes;
	private int CurSize;
	private Entry first; 
	private Entry last;
	
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	CurSize = 0;
    	nodes = new HashMap<Integer, Entry>();
    }
    
    public int get(int key) {
    	Entry node = nodes.get(key);
    	if( node != null ) {
    		MoveToHead(node);
    		return node.value;
    	}
    	else 
    		return -1;        
    }
    
    public void set(int key, int value) {
        Entry node = nodes.get(key);
        if( node == null ) {
        	if( CurSize >= capacity ) {
        		nodes.remove(last.key);
        		RemoveLast();
        	}
        	else
        		CurSize++;
        	node = new Entry();
        }
        if( CurSize == 1 ) {
        	first = node;
        	last = node;        	
        }	
        node.key = key;
        node.value = value;
        MoveToHead(node);
        nodes.put(key, node);
    }
    
    private void MoveToHead(Entry node) {
    	if( node == first )	return;
    	if( node.pre != null ) 
    		node.pre.next = node.next; // delete current node from doubly linked list
    	if( node.next != null )
    		node.next.pre = node.pre;
    	if( last == node )
    		last = node.pre;
    	if( first != null ) {
    		node.next = first;
    		first.pre = node;
    	}
    	first = node;
    	node.pre = null;
    }
    
    private void RemoveLast() {
    	if( last != null ) {
    		if( last.pre != null ) 
    			last.pre.next = null;
    		else
    			first = null;
    		last = last.pre;
    	}
    }
}

class Entry {
	Entry pre;
	Entry next;
	int key;
	int value;
}
