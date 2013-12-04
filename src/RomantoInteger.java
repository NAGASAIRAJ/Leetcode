
public class RomantoInteger {
    public int romanToInt(String s) {
    	if( s == null || s.length() == 0 )
    		return 0;
    	int result = 0;
    	for( int i = 0; i < s.length(); i++ ) {
    		if( (i > 0) && ChartoInt(s.charAt(i-1)) < ChartoInt(s.charAt(i)))
    			result += (ChartoInt(s.charAt(i)) - ChartoInt(s.charAt(i-1)));
    		else
    			result += ChartoInt(s.charAt(i));
    	}
    	return result;
    }
    private int ChartoInt(char c) {
    	switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
    	}    		
    }
}
