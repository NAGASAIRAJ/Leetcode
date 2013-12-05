import java.util.ArrayList;


public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if( root == null ) return result;
    	ArrayList<Integer> seqs = new ArrayList<Integer>();
    	FindPathSum(root, seqs, 0, sum, result);
    	return result;
    }
    public void FindPathSum(TreeNode root, ArrayList<Integer> seqs, 
    				int CurSum, int ExpectSum, ArrayList<ArrayList<Integer>> result) {
    	//if( root == null )	return result;
    	CurSum += root.val;
    	seqs.add(root.val);
    	boolean IsLeaf = (root.left == null) && (root.right == null);
    	if( CurSum == ExpectSum && IsLeaf ) {
    		ArrayList<Integer> tmp = new ArrayList<Integer>();
    		tmp.addAll(seqs);
    		result.add(tmp);
    		seqs.remove(seqs.size()-1);
    		return;
    	}
    	if( root.left != null )
    		FindPathSum(root.left, seqs, CurSum, ExpectSum, result);
    	if( root.right != null )
    		FindPathSum(root.right, seqs, CurSum, ExpectSum, result);
    	seqs.remove(seqs.size()-1);
    }
    
}
