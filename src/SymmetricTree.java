
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode5 root) {
        if( root == null )	return true;
        return compare(root.left, root.right);
    }
    
    public static boolean compare(TreeNode5 left, TreeNode5 right) {
    	if( left == null && right == null )
    		return true;
    	if( (left != null && right == null) || (left == null && right != null))
    		return false;
    	if( left.val == right.val )
    		return (compare(left.left, right.right) && 
    				(compare(left.right, right.left)));
    	return false;
    }
    
    public static boolean isSymmetric2(TreeNode5 root) {
        if( root == null )	return true;
        TreeNode5 left = root.left;
        TreeNode5 right = root.right;
    	java.util.LinkedList<TreeNode5> l = new java.util.LinkedList<TreeNode5>();
    	java.util.LinkedList<TreeNode5> r = new java.util.LinkedList<TreeNode5>();
    	l.add(left);
    	r.add(right);
    	while( !l.isEmpty() && !r.isEmpty() ) {
    		left = l.pop();
    		right = r.pop();
    		
        	if( (left != null && right == null) || (left == null && right != null))
        		return false;
        	if( left.val == right.val ) {
        		l.add(left.left);
        		l.add(left.right);
        		r.add(right.right);
        		r.add(right.left);
        	}
        	else 
        		return false;
    	}
        return true;
    }
    
	public static void main(String[] args) {
		TreeNode5 root = new TreeNode5(1);
		root.left = new TreeNode5(2);
		root.right = new TreeNode5(2);
		root.left.left = new TreeNode5(3);
		root.left.right = new TreeNode5(4);
		root.right.left = new TreeNode5(4);
		root.right.right = new TreeNode5(3);
		
		TreeNode5 root2 = new TreeNode5(1);
		root2.left = new TreeNode5(2);
		root2.right = new TreeNode5(2);
		root2.left.right = new TreeNode5(3);
		root2.right.right = new TreeNode5(3);
		
		if( isSymmetric(root) )
			System.out.println("Recusively, Tree1 is a symmetric tree!");
		else 
			System.out.println("Recusively, Tree1 is not a symmetric tree!");
		
		if( isSymmetric(root2) )
			System.out.println("Recusively, Tree2 is a symmetric tree!");
		else 
			System.out.println("Recusively, Tree2 is not a symmetric tree!");
		
		if( isSymmetric2(root) )
			System.out.println("Iteratively, Tree1 is a symmetric tree!");
		else 
			System.out.println("Iteratively, Tree1 is not a symmetric tree!");
		
		if( isSymmetric2(root2) )
			System.out.println("Iteratively, Tree2 is a symmetric tree!");
		else 
			System.out.println("Iteratively, Tree2 is not a symmetric tree!");
	}
}

class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5(int x) { val = x; }
}

