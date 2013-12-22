import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if( num.length < 3 )	return res;
		Arrays.sort(num);
		Set<ArrayList<Integer>> NoDupRes = new HashSet<ArrayList<Integer>>();
		int l, r;
		for( int i = 0; i < num.length - 2; i++ ) {
			l = i + 1;
			r = num.length - 1;
			while( l < r ) {
				if( num[i] + num[l] + num[r] == 0 ) {
					ArrayList<Integer> TmpRes = new ArrayList<Integer>();
					TmpRes.add(num[i]);
					TmpRes.add(num[l]);
					TmpRes.add(num[r]);
					if( NoDupRes.add(TmpRes) ) 					
						res.add(TmpRes);				
					l++;
					r--;
				}
				else if( num[i] + num[l] + num[r] < 0 )
					l++;
				else 
					r--;
			}
		}
		return res;
	}
}
