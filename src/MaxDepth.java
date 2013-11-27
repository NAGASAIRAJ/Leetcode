
public class MaxDepth {
    public static int maxDepth(TreeNode3 root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.	
    	if( root == null ) return 0;
                
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	
	public static void main(String[] args) {
		TreeNode3 root = new TreeNode3(1);
		root.right = new TreeNode3(2);
		root.right.left = new TreeNode3(3);

		System.out.print("Max Depth: " + maxDepth(root));
	}
}

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3(int x) { val = x; }
}