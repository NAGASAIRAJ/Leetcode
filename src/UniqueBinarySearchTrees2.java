import java.util.ArrayList;


public class UniqueBinarySearchTrees2 {
    public ArrayList<TreeNode> generateTrees(int n) {
    	if( n == 0 )	return null;
    	return GenerateBST(1, n);	
    }
    private ArrayList<TreeNode> GenerateBST(int start, int end) {
    	ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
    	if( start > end ) {
    		trees.add(null);
    		return trees;    		
    	}
    	for( int i = start; i <= end; i++ ) {
    		ArrayList<TreeNode> LeftTree = GenerateBST(start, i - 1);
    		ArrayList<TreeNode> RightTree = GenerateBST(i + 1, end);
    		for( int j = 0; j < LeftTree.size(); j++ ) {
    			for( int k = 0; k < RightTree.size(); k++ ) {
    				TreeNode root = new TreeNode(i);
    				root.left = LeftTree.get(j);
    				root.right = RightTree.get(k);
    				trees.add(root);
    			}
    		}
    	}
    	return trees;
    }
}
