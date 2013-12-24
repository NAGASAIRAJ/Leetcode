
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int SLen = s.length(), PLen = p.length();
		int i = 0, j = 0;
		int ss = 0, PStart = -1;
		
		while( i < SLen ) {
			
			while( j < PLen && p.charAt(j) == '*' ) {
				PStart++;
				ss = i;
			}
			
			if( (j == PLen) || (s.charAt(i) != p.charAt(j) &&
					            p.charAt(j) != '?')) {
				if( PStart < 0 )
					return false;
				else {
					j = PStart + 1;
					i = ++ss;
				}
			}
			else {
				i++;
				j++;
			}
		}	
		
		while( j < PLen && p.charAt(j) == '*' ) 
			j++;
		
		return (j == PLen);
		
    }
}
