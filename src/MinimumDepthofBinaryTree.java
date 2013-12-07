
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
    	if( root == null )	return 0;
    	int LeftDepth = 0, RightDepth = 0;
    	if( root.left != null )
    		LeftDepth = minDepth(root.left);
    	if( root.right != null )
    		RightDepth = minDepth(root.right);
    	if( root.left != null && root.right != null)
    		return 1 + Math.min(LeftDepth, RightDepth);
    	else if( root.left != null && root.right == null )
    		return 1 + LeftDepth;
    	else if( root.left == null && root.right != null )
    		return 1 + RightDepth;
    	else
    		return 1;    	
    }
}
