import java.util.Set;
import java.util.ArrayList;

public class WordBreak2 {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if( s == null || dict.size() <= 0 )
			return res;
		int length = s.length();
		// seg(i, j) means substring t start from i and length is j  
		// can be segmented into dictionary words
		boolean[][] seg = new boolean[length][length + 1];
		for( int len = 1; len <= length; len++ ) {
			for( int i = 0; i < length - len + 1; i++ ) {
				String t = s.substring(i, i + len);
				if( dict.contains(t) ) {
					seg[i][len] = true;
					continue;
				}
				for( int k = 1; k < len; k++ ) {
					if( seg[i][k]  && seg[i + k][len - k] ) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}
		if( !seg[0][length] )
			return res;
		int depth = 0;
		dfs(s, seg, 0, length, depth, res, new StringBuffer(), dict);
		return res;		
    }
	private void dfs(String s, boolean[][] seg, int start, int length, 
			int depth, ArrayList<String> res, StringBuffer StrBuf, Set<String> dict) {
		if( depth == length ) {
			String t = StrBuf.toString();
			res.add(t.substring(0, t.length() - 1));
			return;
		}
		for( int len = 1; len <= length; len++ ) {
			if( seg[start][len] ) {
				String t = s.substring(start, start + len);
				if( !dict.contains(t) )
					continue;
				int BeforeAddLen = StrBuf.length();
				StrBuf.append(t).append(" ");
				dfs(s, seg, start + len, length, start + len, res, StrBuf, dict);
				StrBuf.delete(BeforeAddLen, StrBuf.length());
			}
		}
	}
}
