
public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	if( s == null || s.length() == 0 || nRows <= 1 )
    		return s;
    	return GenerateStr(s, nRows);
    }
    private String GenerateStr(String s, int nRows) {
    	int len = s.length();
    	StringBuffer buffer = new StringBuffer();
    	int diff = 2 * nRows - 2;
    	for( int i = 0; i < nRows && i < len; i++ ) {
    		if( i == 0 || i == nRows - 1 ) {
    			buffer.append(s.charAt(i));
    			int index = i;
    			while( index + diff < len ) {
    				buffer.append(s.charAt(index + diff));
    				index = index + diff;
    			}
    		}
    		else {
    			buffer.append(s.charAt(i));
    			int index = i;
    			while( 2 * nRows - 2 * i - 2 + index < len ||
    					index + diff < len ) {
    				if( 2 * nRows - 2 * i - 2 + index < len )
    					buffer.append(s.charAt(2 * nRows - 2 * i - 2 + index));
    				if( index + diff < len )
    					buffer.append(s.charAt(index + diff));
    				index += diff;
    			}
    		}    			
    	}
    	return buffer.toString();
    }
}
