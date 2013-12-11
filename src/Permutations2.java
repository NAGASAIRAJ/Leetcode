import java.util.ArrayList;
import java.util.HashSet;


public class Permutations2 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if( num.length == 0 )	return result;
		HashSet<ArrayList<Integer>> TmpPer = new HashSet<ArrayList<Integer>>();
		GeneratePermutation(0, num.length, num, TmpPer, result);
		return result;
    }
	private void GeneratePermutation(int depth, int len, int[] num, HashSet<ArrayList<Integer>> TmpPer,
										ArrayList<ArrayList<Integer>> result) {
		if( depth == len ) {
			ArrayList<Integer> per = new ArrayList<Integer>();
			for( int i = 0; i < len; i++ )
				per.add(num[i]);
			if( TmpPer.add(per) )
				result.add(per);
		}
		for( int i = depth + 1; i < len; i++ ) {
			int tmp = num[depth];
			num[depth] = num[i];
			num[i] = tmp;
			
			GeneratePermutation(depth + 1, len, num, TmpPer, result);
			
			tmp = num[depth];
			num[depth] = num[i];
			num[i] = tmp;
		}
	}
}
