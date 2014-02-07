
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if( len3 != len1 + len2 )
			return false;
		boolean[][] match = new boolean[len1 + 1][len2 + 1];
		match[0][0] = true;
		int i = 1;
		
		while( i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1) ) {
			match[i][0] = true;
			i++;
		}
		
		int j = 1;
		
		while( j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1) ) {
			match[0][j] = true;
			j++;
		}
		
		// match[m][n] denotes if s1 of length of m and s2 of length
		// n could form s3 of length (m + n)
		for( int m = 1; m <= len1; m++ ) {
			for( int n = 1; n <= len2; n++ ) {
				char c = s3.charAt(m + n - 1);
				if( c == s1.charAt(m - 1) ) 
					match[m][n] |= match[m - 1][n];
				if( c == s2.charAt(n - 1) )
					match[m][n] |= match[m][n - 1];
				
			}
		}
		
		return match[len1][len2];
    }
}
