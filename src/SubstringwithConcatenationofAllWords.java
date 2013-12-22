import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class SubstringwithConcatenationofAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int len = L.length;
		if( len == 0 )	{
			res.add(0);
			return res;
		}
		int M = S.length();
		int N = L[0].length();
		Map<String, Integer> expected = new HashMap<String, Integer>();
		Map<String, Integer> real = new HashMap<String, Integer>();
		for( int i = 0; i < len; i++ ) {
			if( expected.get(L[i]) == null ) {
				expected.put(L[i], 1);
				real.put(L[i], 0);				
			}
			else
				expected.put(L[i], expected.get(L[i]) + 1);
		}
		for( int i = 0; i <= (M - N * len); i++ ) {
			int j = 0;
			for( ; j < len; ) {
				String tmp = S.substring(i + j * N, i + (j + 1) * N);
				if( expected.get(tmp) == null )
					break;
				else {
					real.put(tmp, real.get(tmp) + 1);
					if( real.get(tmp) > expected.get(tmp) )
						break;
					j++;					
				}
			}
			if( j == len )
				res.add(i);
			for( int m = 0; m < len; m++ )
				real.put(L[m], 0);
			
		}
		return res;
    }
}
