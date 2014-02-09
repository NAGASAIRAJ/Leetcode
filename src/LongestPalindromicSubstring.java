
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		//String s = "bb";
		String s2 = "abb";
		//System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome(s2));
		
		String s2_1 = "bb";
		String s2_2 = "abb";
		System.out.println(longestPalindrome2(s2_1));
		System.out.println(longestPalindrome2(s2_2));
	}
	
	public static String longestPalindrome(String s) {
		if( s.length() == 0 )	return "";	// try dynamic programming (summary) 
		String LongestStr = "";
		for( int i = 0; i < s.length() - 1; i++ ) {
			String OddStr = ExpandAroundCenter(s, i, i);
			System.out.println(OddStr);
			if( OddStr.length() > LongestStr.length() )
				LongestStr = OddStr;
			String EvenStr = ExpandAroundCenter(s, i, i + 1);
			System.out.println(EvenStr);
			if( EvenStr.length() > LongestStr.length() )
				LongestStr = EvenStr;			
		}
		return LongestStr;
    }
	private static String ExpandAroundCenter(String s, int l, int r) {
		int l_tmp = l, r_tmp = r;
		boolean FirstTime = true;

		while( l_tmp >= 0 && r_tmp < s.length() && s.charAt(l_tmp) == s.charAt(r_tmp) ) {
		    if( FirstTime )
		        FirstTime = false;
			l_tmp--;
			r_tmp++;
		}
			
		if( !FirstTime ) {
			l_tmp++;
			r_tmp--;
		}
		else
			r_tmp--;
		
		return s.substring(l_tmp, r_tmp + 1);
	}
	
	public static String Preprocess(String s) {
		String res = "";
		res += "^"; // string start
		for( int i = 0; i < s.length(); i++ )
			res = res + "#" + s.charAt(i);
		res += "#";
		res += "$"; // string end
		return res;
	}
	
	public static String longestPalindrome2(String s) {
		String TmpS = Preprocess(s);
		int[] p = new int[TmpS.length()];
		int CenterIdx = 0, MaxBound = 0;
		for( int i = 1; i < TmpS.length() - 1; i++ ) {
			int j = 2 * CenterIdx - i; // i's mirror index in right
			if( MaxBound > i )
				p[i] = Math.min(MaxBound - i, p[j]);
			else 
				p[i] = 0;
			
			while( TmpS.charAt(i - 1 - p[i]) == 
						TmpS.charAt(i + 1 + p[i] )) 
				p[i]++;
			
			if( i + p[i] > MaxBound ) {
				MaxBound = i + p[i];
				CenterIdx = i;
			}
			
		}
		int MaxLen = 0;
		for( int i = 1; i < TmpS.length() - 1; i++ ) {
			if( p[i] > MaxLen ) {
				MaxLen = p[i];
				CenterIdx = i;
			}
		}
		int start = (CenterIdx - 1 - MaxLen) >> 1; 
		return s.substring(start, start + MaxLen + 1);
	}
}
