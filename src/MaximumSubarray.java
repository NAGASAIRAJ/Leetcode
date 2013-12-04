
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
    	if( A.length == 0 ) return 0;
    	if( A.length == 1 ) return A[0];
    	int max = Integer.MIN_VALUE;
    	int tmp_max = 0;
    	for( int i = 0; i < A.length; i++ ) {
    		tmp_max += A[i];
    		if( tmp_max > max )
    			max = tmp_max;
    		else if( tmp_max < 0 )
    			tmp_max = 0;
    	}
    	return max;
    }
}
