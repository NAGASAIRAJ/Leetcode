
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
    	if( s.length() == 0 )	return 0;
    	String[] strs = s.split(" ");
    	for( int i = strs.length - 1; i >= 0; i-- ) {
    		if( IsWord(strs[i]) )
    			return strs[i].length();
    	}
    	return 0;
    }
    private boolean IsWord(String s) {
    	if( s.length() == 0 )
    		return false;
    	char c = ' ';
    	for( int i = 0; i < s.length(); i++ ) {
    		c = s.charAt(i);
    		if( (c < 'a'  && c > 'Z') || c < 'A' || c > 'z' )
    			return false;
    	}
    	return true;
    }
}
