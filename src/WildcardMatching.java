
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
				if( PStart < 0 )
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
}
