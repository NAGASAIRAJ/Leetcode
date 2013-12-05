
public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	digits[len-1] += 1;
    	int carry = 0;
    	for( int i = len - 1; i >= 0; i-- ) {
    		digits[i] += carry;
    		carry = 0;
    		if( digits[i] >= 10 ) {
    			carry = 1;
    			digits[i] -= 10;
    		}
    	}
    	if( carry == 1 ) {
    		int[] results = new int[len+1];
    		results[0] = 1;
    		for( int i = 0; i < len; i++ )
    			results[i+1] = digits[i];
    		return results;
    	}
    	else 
    		return digits;
    }
}
