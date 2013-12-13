
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	int[] CharIndex = new int[26];
    	Reset(CharIndex);
    	int MaxLen = 0, start = 0;
    	for( int i = 0; i < s.length(); i++ ) {
    		int it = s.charAt(i) - 'a';
    		if( CharIndex[it] >= 0 ) {
    			if( MaxLen < i - start )
    				MaxLen = i - start;
    			i = CharIndex[it];
    			start = i + 1;
    			Reset(CharIndex);
    			continue;
    		}
    		CharIndex[it] = i;
    	}
    	if( MaxLen < s.length() - start )
    		MaxLen = s.length() - start;
    	return MaxLen;
    }
    private void Reset(int[] CharIdx) {
    	for( int i = 0; i < CharIdx.length; i++ )
    		CharIdx[i] = -1;
    }
}
