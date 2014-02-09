
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if( S.length() == 0 || S == null )
			return 0;
		if( T.length() == 0 || T == null )
			return 1;
		int SLen = S.length(), TLen = T.length();
		if( SLen < TLen )
			return 0;
		int[][] NumDisSub = new int[SLen + 1][TLen + 1];
		for( int i = 0; i < SLen + 1; i++ )
			NumDisSub[i][0] = 1;
		for( int i = 1; i < TLen + 1; i++ )
			NumDisSub[0][i] = 0;
		for( int i = 1; i < SLen + 1; i++ ) {
			for( int j = 1; j < TLen + 1; j++ ) {
				if( S.charAt(i - 1) == T.charAt(j - 1) )
					NumDisSub[i][j] = NumDisSub[i - 1][j - 1] + 
										NumDisSub[i - 1][j];
				else 
					NumDisSub[i][j] = NumDisSub[i - 1][j];
			}		
		}
		return NumDisSub[SLen][TLen];
	}
	
	public int numDistinct2(String S, String T) {
        int[] f = new int[T.length() + 1];
        f[T.length()] = 1;
        for( int i = S.length() - 1; i >= 0; i-- ) {
            for(int j = 0; j < T.length(); j++) {
                f[j] += (S.charAt(i) == T.charAt(j))?  f[j+1] : 0;
            }
        }
        return f[0];
    }
}
