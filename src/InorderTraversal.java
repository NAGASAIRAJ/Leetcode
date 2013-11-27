import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public static ArrayList<Integer> inorderTraversal(TreeNode2 root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if( root == null ) return result;
        Stack<TreeNode2> st = new Stack<TreeNode2>();
        st.push(root);
        TreeNode2 current = null;
        while( current != null || !st.empty() ) {
        	if( current != null ) {
        		st.push(current);
        		current = current.left;
        	}
        	else {
        		current = st.pop();
        		result.add(current.val);
        		current = current.right;
        	}
        }
       
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode2 root = new TreeNode2(1);
		root.right = new TreeNode2(2);
		root.right.left = new TreeNode2(3);
		ArrayList<Integer> result = inorderTraversal(root);
		for( int i = 0; i < result.size(); i++ )
			System.out.print(result.get(i) + " ");
	}
}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x) { val = x; }
}