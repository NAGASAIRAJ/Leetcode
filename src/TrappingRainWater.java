
public class TrappingRainWater {
    public int trap(int[] A) {
    	if( A.length == 0 )	return 0;
    	int MinHeight = 0, l = 0, r = 0, result = 0;
    	for( int i = 1; i < A.length; i++ ) {
    		for( int j = 0; j < i; j++ ) {
    			if( A[j] > l )
    				l = A[j];
    		}
    		for( int j = A.length - 1; j > i; j-- ) {
    			if( A[j] > r )
    				r = A[j];
    		}
    		MinHeight = Math.min(l, r);
    		if( MinHeight > A[i] )
    			result += (MinHeight - A[i]);    		
    	}
    	return result;
    }
}
