
public class EditDistance {
    public int minDistance(String word1, String word2) {
    	int len1 = word1.length(), len2 = word2.length();
    	int[][] ed = new int[len1 + 1][len2 + 1];
    	for( int i = 0; i < len1 + 1; i++ ) {
    		for( int j = 0; j < len2 + 1; j++ ) {
    			if( i == 0 ) 
    				ed[i][j] = j;
    			else if( j == 0 )
    				ed[i][j] = i;
    			else {
    				if( word1.charAt(i - 1) == word2.charAt(j - 1))
    					ed[i][j] = ed[i - 1][j - 1];
    				else 
    					// replace ch1 with ch2: 1+ ed[i-1][j-1]
    					// insert ch2 in word2(word1+ch1, word2): 1 + ed[i][j-1j]
    					// delete ch1 from word1(word1, word2+ch2): 1 + ed[i-1][j]
    					ed[i][j] = 1 + Math.min(ed[i - 1][j - 1], 
    							                Math.min(ed[i - 1][j], ed[i][j - 1]));
    			}
    		}
    	}
    	return ed[len1][len2];
    }
}
