import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if( S.length == 0 )	return result;
    	Arrays.sort(S);
    	GenerateSubset(0, S.length, S, new ArrayList<Integer>(), result);
    	return result;
    }
    public void GenerateSubset(int depth, int len, int[] nums, ArrayList<Integer> subset, 
    							ArrayList<ArrayList<Integer>> result) {
    	result.add(subset);
    	if( depth == len ) 
    		return;
    	
    	for( int i = depth; i < len; i++ ) {
    		ArrayList<Integer> TmpSubset = new ArrayList<Integer>();
    		TmpSubset.addAll(subset);
    		TmpSubset.add(nums[i]);
    		GenerateSubset(i + 1, len, nums, TmpSubset, result);
    	}
    }
}
