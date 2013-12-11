import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
    	if( candidates.length == 0 )	return combinations;
    	Arrays.sort(candidates);
    	ArrayList<Integer> combination = new ArrayList<Integer>();
    	int depth = 0, sum = 0;
    	DFS(depth, target, sum, candidates, combination, combinations);
    	return combinations;
    }
    private void DFS(int depth, int target, int sum, int[] candidates, ArrayList<Integer> combination, 
    		ArrayList<ArrayList<Integer>> combinations) {
    	if( sum > target )	return;
    	else if( sum == target ) {
    		ArrayList<Integer> TmpCom = new ArrayList<Integer>();
    		TmpCom.addAll(combination);
    		combinations.add(TmpCom);
    		return;
    	}
    	else {
    		for( int i = depth; i < candidates.length; i++ ) {
    			sum += candidates[i];
    			combination.add(candidates[i]);
    			DFS(i, target, sum, candidates,  combination, combinations);
    			combination.remove(combination.size() - 1);
    			sum -= candidates[i];
    		}
    	}
    }
}
