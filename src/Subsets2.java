import java.util.ArrayList;
import java.util.Arrays;


public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
    	if( num.length == 0 )
    		return subsets;
    	Arrays.sort(num);
    	GenerateSubset(0, num.length, num, new ArrayList<Integer>(), subsets);
    	return subsets;
    }
    private void GenerateSubset(int depth, int len, int[] num, ArrayList<Integer> subset, 
    							ArrayList<ArrayList<Integer>> subsets) {
    	subsets.add(subset);
    	if( depth == len )	return;
    	for( int i = depth; i < len; i++ ) {
    		ArrayList<Integer> TmpSubset = new ArrayList<Integer>();
    		TmpSubset.addAll(subset);
    		TmpSubset.add(num[i]);
    		GenerateSubset(i + 1, len, num, TmpSubset, subsets);
    		while( i + 1 < len && num[i] == num[i + 1] )
    			i++;
    	}
    }
}
