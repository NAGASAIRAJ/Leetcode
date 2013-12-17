import java.util.ArrayList;


public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
    	if( root == null )	return;
    	ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();    	
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	InorderTraversal(root, nodes, values);
    	for( int i = 0; i < nodes.size(); i++ )
    		nodes.get(i).val = values.get(i);
    }
    private void InorderTraversal(TreeNode root, ArrayList<TreeNode> nodes, 
    								ArrayList<Integer> values) {
    	if( root == null ) return;
    	if( root.left != null ) 
    		InorderTraversal(root.left, nodes, values);
    	nodes.add(root);
    	values.add(root.val);
    	if( root.right != null )
    		InorderTraversal(root.right, nodes, values);
    }
}
