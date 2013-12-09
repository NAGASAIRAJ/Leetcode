import java.util.ArrayList;


public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if( root == null )	return result;
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		boolean Backward = true;
		current.add(root);
		while( !current.isEmpty() ) {
			for( TreeNode node : current )
				temp.add(node.val);
			result.add(temp);
			for( int i = current.size() - 1; i >= 0; i-- ) {
				TreeNode node = current.get(i);
				if( Backward ) {
					if( node.right != null )	next.add(node.right);
					if( node.left != null )		next.add(node.left);
				}
				else {
					if( node.left != null )		next.add(node.left);
					if( node.right != null )	next.add(node.right);					
				}
			}
			Backward = Backward ? false : true;
			current = new ArrayList<TreeNode>(next);
		}
		
		return result;
	}
}