import java.util.ArrayList;


public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
    	if( num.length == 0 )	return combinations;
    	ArrayList<Integer> combination = new ArrayList<Integer>();
    	int sum = 0, depth = 0;
    	FindCombinations(depth, sum, target, num, combination, combinations);
    	return combinations;
    }
    private void FindCombinations(int depth, int sum, int target, int[] num, 
    		ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> combinations) {
    	if( sum > target )	return;
    	else if( sum == target ) {
    		ArrayList<Integer> TmpCom = new ArrayList<Integer>();
    		TmpCom.addAll(combination);
    		combinations.add(TmpCom);
    		return;
    	}
    	else {
    		for( int i = depth; i < num.length; i++ ) {
    			sum += num[i];
    			combination.add(num[i]);
    			FindCombinations(i + 1, sum, target, num, combination, combinations);
    			sum -= combination.get(combination.size() - 1);
    			combination.remove(combination.size() - 1);
    			
    			while( i < num.length - 1 && num[i] == num[i + 1])
    				i++;    			
    		}
    	}
    		
    }
}
