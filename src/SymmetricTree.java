
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
    
	public static void main(String[] args) {
		TreeNode5 root = new TreeNode5(1);
		root.left = new TreeNode5(2);
		root.right = new TreeNode5(2);
		root.left.left = new TreeNode5(3);
		root.left.right = new TreeNode5(4);
		root.right.left = new TreeNode5(4);
		root.right.right = new TreeNode5(3);
		
		if( isSymmetric(root) )
			System.out.println("This is a symmetric tree!");
		else 
			System.out.println("This is not a symmetric tree!");
	}
}

class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5(int x) { val = x; }
}

