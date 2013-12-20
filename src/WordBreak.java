import java.util.Set;


public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if( s == null || dict.size() <= 0 )
			return false;
		int len = s.length();
		boolean[] seg = new boolean[len + 1];
		seg[0] = true;
		for( int i = 1; i <= len; i++ )
			seg[i] = false;
		// seg[i] means substring t starting from 0 and length is i can be
		// segmented into dictionary words
		for( int TmpLen = 1; TmpLen <= len; TmpLen++ ) {
			for( int i = 0; i < TmpLen; i++ ) {
				String t = s.substring(i, TmpLen);
				if( seg[i] && dict.contains(t) ) {
					seg[TmpLen] = true;
					break;
				}				
			}				
		}
		return seg[len];
    }
}
