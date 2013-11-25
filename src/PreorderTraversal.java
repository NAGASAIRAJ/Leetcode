import java.util.*;

public class PreorderTraversal {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	if( root == null ) return null;
    	ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        
        while( !st.empty() ) {
        	TreeNode tmp = st.pop();
        	result.add(tmp.val);
        	if( tmp.right != null ) st.push(tmp.right);
        	if( tmp.left != null ) st.push(tmp.left);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		ArrayList<Integer> result = preorderTraversal(root);
		for( int i = 0; i < result.size(); i++ )
			System.out.println(result.get(i) + " ");
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}