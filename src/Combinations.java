import java.util.ArrayList;


public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if( k == 0 )	return result;
		ArrayList<Integer> combinations = new ArrayList<Integer>();
		int depth = 1;
		GenerateCombination(n, k, depth, combinations, result);
		return result;
    }
	public void GenerateCombination(int n, int k, int depth, ArrayList<Integer> combinations, 
			ArrayList<ArrayList<Integer>> result) {
		if( combinations.size() == k ) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.addAll(combinations);
			result.add(tmp);
			return;
		}
		for( int i = depth; i <= n; i++ ) {
			combinations.add(i);
			GenerateCombination(n, k, i+1, combinations, result);
			combinations.remove(combinations.size() - 1);
		}
	}
}
