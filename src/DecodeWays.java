
public class DecodeWays {
	public int numDecodings(String s) {
		int len = s.length();
		if( 0 == len || s.charAt(0) == '0' )
			return 0;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for( int i = 2; i < len + 1; i++ ) {
			char CurChar = s.charAt(i - 1);
			int CurNum = CurChar - '0';
			if( CurNum == 0 ) {	// s[i] is not valid
				String TwoNum = s.substring(i - 2, i);
				if( Integer.parseInt(TwoNum) <= 26 &&
						Integer.parseInt(TwoNum) >= 10 ) // s[i - 1][i] is valid 
					dp[i] = dp[i - 2];
				else 
					dp[i] = 0;				
			}
			else { // s[i] is valid
				String TwoNum = s.substring(i - 2, i);
				if( Integer.parseInt(TwoNum) <= 26 && 
						Integer.parseInt(TwoNum) >= 10 )
					dp[i] = dp[i - 1] + dp[i - 2];
				else 
					dp[i] = dp[i - 1];  
			}
		}
		return dp[len];
    }
}
