import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if( root == null )	return result;
		int current_level = 0, next_level = 1;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while( !queue.isEmpty() ) {    		
			current_level = next_level;
			next_level = 0;
			ArrayList<Integer> nums = new ArrayList<Integer>();    		
			for( int i = 0; i < current_level; i++ ) {
				TreeNode tmp = queue.pop();
				nums.add(tmp.val);
				if( tmp.left != null ) {
					queue.add(tmp.left);
					next_level++;
				}
				if( tmp.right != null ) {
					queue.add(tmp.right);
					next_level++;
				}
			}
			result.add(nums);
		}
		
		return result;
	}
}
