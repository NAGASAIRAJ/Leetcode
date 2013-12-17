
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
    	for( int i = 0; i < A.length; i++ ) {
    		while( 0 < A[i] && A[i] != (i + 1) &&
    				A[i] <= A.length ) {
    			if( A[i] == A[ A[i] - 1 ] )
    				break;
    			int tmp = A[i];
    			A[i] = A[A[i] - 1];
    			A[tmp - 1] = A[i];
    		}
    	}
    	int idx;
    	for( idx = 0; idx < A.length; idx++ ) {
    		if( A[idx] < 0 || A[idx] != (idx + 1) )
    			return (idx + 1);
    	}
    	return (idx + 1);
    }
}
