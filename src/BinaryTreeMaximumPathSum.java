
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		FindMaxPath(root, res);
		return res[0];		
	}
	private int FindMaxPath(TreeNode root, int[] res) {
		if( root == null )
			return 0;
		int left = FindMaxPath(root.left, res);
		int right = FindMaxPath(root.right, res);
		int arch = root.val + left + right;
		int single = Math.max(root.val, Math.max(left, right) + root.val);
		res[0] = Math.max(res[0],  Math.max(arch, single));
		return single;
	}
}
