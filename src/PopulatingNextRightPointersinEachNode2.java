
public class PopulatingNextRightPointersinEachNode2 {
    public void connect(TreeLinkNode root) {
        if( root == null )	return;
        if( root.left != null ) {
        	if( root.right == null ) {
	        	TreeLinkNode tmp = root.next;
	        	boolean flag = true;
	        	while( tmp != null && flag ) {
	        		if( tmp.left != null ) {
	        			root.left.next = tmp.left;
	        			flag = false;
	        		}
	        		else if( tmp.right != null ) {
	        			root.left.next = tmp.right;
	        			flag = false;
	        		}
	        		else
	        			tmp = tmp.next;
	        	}
        	}
        	else 
        		root.left.next = root.right;
        }
        if( root.right != null ) {
        	if( root.next == null )
        		root.right.next = null;
        	else {
        		TreeLinkNode tmp = root.next;
	        	boolean flag = true;
	        	while( tmp != null && flag ) {
	        		if( tmp.left != null ) {
	        			root.right.next = tmp.left;
	        			flag = false;
	        		}
	        		else if( tmp.right != null ) {
	        			root.right.next = tmp.right;
	        			flag = false;
	        		}
	        		else
	        			tmp = tmp.next;
	        	}
        	}        		
        }
        connect(root.right);
        connect(root.left);
    }
    
    public void connect2(TreeLinkNode root) {
        if( root == null )	return;
        TreeLinkNode tmp = root.next;
        while( tmp != null ) {
        	if( tmp.left != null ) {
        		tmp = tmp.left;
        		break;
        	}
        	if( tmp.right != null ) {
        		tmp = tmp.right;
        		break;
        	}
        	tmp = tmp.next;
        }
        if( root.left != null ) {
        	if( root.right == null )
        		root.left.next = tmp;
        	else 
        		root.left.next = root.right;
        }
        if( root.right != null ) {
        	if( root.next == null )
        		root.right.next = null;
        	else 
        		root.right.next = tmp;
        }
        
        connect2(root.right);
        connect2(root.left);
    }
}
