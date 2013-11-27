import java.util.*;

public class PostorderTraversal {
    public static ArrayList<Integer> postorderTraversal(TreeNode1 root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if( root == null ) return result;
        Stack<TreeNode1> st = new Stack<TreeNode1>();
        TreeNode1 previous = null;
        st.push(root);
        
        while( !st.empty() ) {
        	TreeNode1 current = st.peek();
        	if( current == null ) st.pop();
        	else if( current.left == null && current.right == null ) {
        		result.add(current.val);
        		st.pop();
        	}
        	else if( current.left == previous ) st.push(current.right);
        	else if( current.right == previous ) {
        		result.add(current.val);
        		st.pop();
        	}        		
        	else st.push(current.left);
        	
        	previous = current;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(1);
		//root.right = new TreeNode1(2);
		root.left = new TreeNode1(2);
		//root.right.left = new TreeNode1(3);
		ArrayList<Integer> result = postorderTraversal(root);
		for( int i = 0; i < result.size(); i++ )
			System.out.print(result.get(i) + " ");
	}
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) { val = x; }
}