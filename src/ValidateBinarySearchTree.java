
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	if( root == null )	return true;
    	return ValidateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean ValidateBST(TreeNode root, int min, int max) {
    	if( root == null )	return true;
    	if( root.val < min || root.val > max )
    		return false;
    	else
    		return ValidateBST(root.left, min, root.val) &&
    				ValidateBST(root.right, root.val, max);
    }
}
