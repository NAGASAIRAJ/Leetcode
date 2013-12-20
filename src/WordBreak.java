import java.util.Set;


public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if( s == null || dict.size() <= 0 )
			return false;
		int len = s.length();
		// seg[i][j] means substring t starting from i and length is j can be
		// segmented into dictionary words
		boolean[][] seg = new boolean[len][len + 1];
		for( int TmpLen = 1; TmpLen <= len; TmpLen++ ) {
			for( int i = 0; i < len; i++ ) {
				String t = s.substring(i, i + TmpLen);
				if( dict.contains(t) ) {
					seg[i][TmpLen] = true;
					continue;
				}
				for( int j = 1; j < TmpLen; j++ ) {
					if( seg[i][j] && seg[i + j][TmpLen - j] ) {
						seg[i][TmpLen] = true;
						break;
					}
				}
			}				
		}
		return seg[0][len];
    }
}
