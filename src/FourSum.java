import java.util.ArrayList;
import java.util.HashSet;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if( num == null || num.length < 4 )
			return result;
		HashSet<ArrayList<Integer>> TmpRes = new HashSet<ArrayList<Integer>>();
		for( int i = 0, iEnd = num.length - 3; i< iEnd; i++ ) {
			for( int j = i + 1, jEnd = num.length - 2; j < jEnd; j++ ) {
				int k = j + 1, l = num.length - 1;
				while( k < l ) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if( sum == target ) {
						ArrayList<Integer> found = new ArrayList<Integer>();
						found.add(i);
						found.add(j);
						found.add(k);
						found.add(l);
						if( TmpRes.add(found) )
							result.add(found);
						k++;
						l--;
					}
					else if( sum < target )
						k++;
					else 
						l--;
				}
			}
		}
		return result;
	}
}
