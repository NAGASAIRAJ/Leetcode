
public class IsSameTree {
    public static boolean isSameTree(TreeNode4 p, TreeNode4 q) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.	
    	boolean p_null = (p == null);
    	boolean q_null = (q == null);
    	
    	if( p_null != q_null ) return false;
    	else if( p == null && q == null )
    		return true;
    	else if( p.val == q.val )
    		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    	else 
    		return false;        
    }
	
	public static void main(String[] args) {
		TreeNode4 p = new TreeNode4(1);
		p.right = new TreeNode4(2);
		p.right.left = new TreeNode4(3);
		TreeNode4 q = new TreeNode4(1);
		q.right = new TreeNode4(2);
		q.right.left = new TreeNode4(3);

		if( isSameTree(p , q) )
			System.out.println("Two trees are same!");
		else
			System.out.println("Two trees are not same!");
	}
}

class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4(int x) { val = x; }
}