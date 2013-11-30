
public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
    	int[] TreeNum = new int[n+1];
    	TreeNum[0] = 1;
    	TreeNum[1] = 1;
    	for( int i = 2; i <=n; i++ ) {
    		for( int j = 1; j <= i; j++ ) {
    			TreeNum[i] += (TreeNum[j-1] * TreeNum[i-j]);
    		}
    	}
    	return TreeNum[n];
        
    }
    
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Unique Binary Search Tree Num: " + numTrees(n));		
	}
}
