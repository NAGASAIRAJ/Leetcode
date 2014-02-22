
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	if( root == null )	return true;
    	return ValidateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean ValidateBST(TreeNode root, int min, int max) {
    	if( root == null )	return true;
    	if( root.val <= min || root.val >= max )
    		return false;
    	else
    		return ValidateBST(root.left, min, root.val) &&
    				ValidateBST(root.right, root.val, max);
    }
    
    private static int pre = Integer.MIN_VALUE;
    private static void ResetPreVal() {
    	pre = Integer.MIN_VALUE;
    }
    
    private static boolean ValidateBST2(TreeNode root) {
    	if( root == null )
    		return true;
    	if( !ValidateBST2(root.left) )
    		return false;
    	if( root.val <= pre )
    		return false;
    	pre = root.val;
    	if( !ValidateBST2(root.right) )
    		return false;
    	return true;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.left = n1;	root.right = n2; n1.left = n3;
		n1.right = n4;	n2.left = n5;
		System.out.println("Tree is " + (ValidateBST2(root) ? "" : "not ") + 
								"Binary Search Tree!");
	
		ResetPreVal(); 	// reset pre for next test case
    	
		System.out.println("Test case 2: ");
		TreeNode root2_1 = new TreeNode(0);
		TreeNode n2_1 = new TreeNode(-1);
		root2_1.left = n2_1;
		System.out.println("Tree 2 is " + (ValidateBST2(root2_1) ? "" : "not ") + 
				"Binary Search Tree!");
    }
}
