import java.util.ArrayList;


public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
    	if( root == null )	return 0;
    	StringBuffer digit = new StringBuffer();
    	ArrayList<String> digits = new ArrayList<String>();
    	CollectDigits(digit, digits, root);
    	int sum = 0;
    	for( int i = 0; i < digits.size(); i++ )
    		sum += Integer.parseInt(digits.get(i));
    	return sum;
    }
    private void CollectDigits(StringBuffer digit, ArrayList<String> digits, TreeNode root) {
    	if( root.left == null && root.right == null ) {
    		digit.append(root.val);
    		digits.add(digit.toString());
    		digit.deleteCharAt(digit.length()-1);
    		return;
    	}
    	digit.append(root.val);
    	if( root.left != null ) {
    		CollectDigits(digit, digits, root.left);
    	}
    	if( root.right != null ) {
    		CollectDigits(digit, digits, root.right);
    	}
    	digit.deleteCharAt(digit.length()-1);
    }
}
