
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	String CommonPrefix = "";
    	if( strs.length == 0 )	return CommonPrefix;
    	int PrefixIndex = 0;
    	
    	while( true ) {
    		char c = ' ';
    		int i;
    		for( i = 0; i < strs.length; i++ ) {    			
    			if( PrefixIndex == strs[i].length() )
    				break;
    			if( i == 0 )
    				c = strs[i].charAt(PrefixIndex);
    			if( c != strs[i].charAt(PrefixIndex) )
    				break;
    		}
    		if( i != strs.length )
    			break;
    		CommonPrefix += c;
    		PrefixIndex++;
    	}
    	
    	return CommonPrefix;
    }
}
