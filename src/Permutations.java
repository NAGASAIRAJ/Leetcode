import java.util.ArrayList;


public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	permutation(num, 0, num.length, result);
    	return result;
    }
    public void permutation(int[] num, int depth, int len, ArrayList<ArrayList<Integer>> result ) {
    	if( depth == len ) {
    		ArrayList<Integer> num_tmp = new ArrayList<Integer>();
    		for( int i = 0; i < len; i++ ) 
    			num_tmp.add(num[i]);
    		result.add(num_tmp);
    	}
    	
    	for( int i = depth; i < len; i++ ) {
    		int tmp = num[i];
    		num[i] = num[depth];
    		num[depth] = tmp;
    			
    		permutation(num, depth+1, len, result);
    			
    		tmp = num[i];
    		num[i] = num[depth];
    		num[depth] = tmp;
    	}    	
    }
}
