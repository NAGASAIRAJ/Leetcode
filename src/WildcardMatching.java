
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int SLen = s.length(), PLen = p.length();
		int i = 0, j = 0;
		int ss = 0, PStart = -1;
		
		while( i < SLen ) {
			
			while( j < PLen && p.charAt(j) == '*' ) { // jump multiple *
				PStart = j++; // match 0 character
				ss = i;
			}
			
			if( (j == PLen) || (s.charAt(i) != p.charAt(j) &&
					            p.charAt(j) != '?')) {
				if( PStart < 0 ) // no * previously
					return false;
				else {
					j = PStart + 1;
					i = ++ss; // match 1 character
				}
			}
			else {
				i++;
				j++;
			}
		}	
		
		while( j < PLen && p.charAt(j) == '*' ) // jump multiple *
			j++;
		
		return (j == PLen);
    }
	
	public boolean isMatch2(String s, String p) {
        int n = s.length(), m = p.length(), i, j, chars=0;
	    for( i = 0; i < m; ++i) 
	    	if(p.charAt(i) != '*' && n < ++chars) 
	    		return false;	// less non-start char in s than p 
	    boolean[] dp = new boolean[n+1];
	    for(i = m-1, dp[n] = true; i >= 0; i--){
	        if( p.charAt(i) == '*'){
	            while( i > 0 && p.charAt(i) == p.charAt(i - 1)) 
	            	--i; //skip multiple *
	            for(j = n; j >= 0 && !dp[j]; j--);
	            for(; j >= 0; j--) 
	            	dp[j] = true;
	        }else{
	            for(j = 0; j < n; j++)
	                dp[j] = (p.charAt(i) == s.charAt(j) || 
	                			p.charAt(i) =='?') ? dp[j + 1] : false;
	                dp[n] = false;
	        }
	    }
	    return dp[0];
	}
}
