
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if( x < 0 ) return false;
    	int ReverseX = ReverseNum(x);
    	if( x == ReverseX )
    		return true;
    	else 
    		return false;
    }
    private int ReverseNum(int x) {
    	boolean negative = x < 0 ? true : false;
    	int x_tmp = Math.abs(x), result = 0;
    	while( x_tmp > 0 ) {
    		result = result * 10 + x_tmp % 10;
    		x_tmp /= 10;    		
    	}
    	if( negative )
    		result *= (-1);
    	return result;    		
    }
}
