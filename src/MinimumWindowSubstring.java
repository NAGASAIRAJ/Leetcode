
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
    	if( S == null || T == null || 
    			S.length() == 0 || T.length() == 0 )
    		return "";
    	int[] NeedToFind = new int[256];
    	int[] HasFound = new int[256];
    	for( int i = 0; i < T.length(); i++ ) 
    		NeedToFind[T.charAt(i)]++;
    	int MinWinLen = Integer.MAX_VALUE;
    	int count = 0, TLen = T.length();
    	int WinStart = 0, WinEnd = 0;
    	for( int start = 0, end = 0; end < S.length(); end++ ) {
    		if( NeedToFind[S.charAt(end)] == 0 )
    			continue;
    		HasFound[S.charAt(end)]++;
    		if( HasFound[S.charAt(end)] <= NeedToFind[S.charAt(end)] )
    			count++;
    		if( count == TLen ) {
    			
    			while( NeedToFind[S.charAt(start)] == 0 ||
    					HasFound[S.charAt(start)] > NeedToFind[S.charAt(start)] ) {
    				if( HasFound[S.charAt(start)] > NeedToFind[S.charAt(start)] )
    					HasFound[S.charAt(start)]--;
    				start++;
    			}
    			
    			int WinLen = end - start + 1;
    			if( WinLen < MinWinLen ) {
    				WinStart = start;
    				WinEnd = end;
    				MinWinLen = WinLen;
    			}
    		}
    	}
    	if( count == T.length() )
    		return S.substring(WinStart, WinEnd + 1);
    	
    	return "";
    }
}
