
public class SearchinRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
    	if( A.length == 0 ) return false;
    	if( A.length == 1 ) {
    		if( A[0] == target ) 
    			return true;
    		else 
    			return false;
    	}
    	int l = 0, r = A.length - 1, m = 0;
    	while( l <= r ) {
    		m = (l + r) / 2;
    		if( A[m] == target )
    			return true;
    		if( A[l] < A[m] ) {
    			if( A[l] <= target && target < A[m] )
    				r = m - 1;
    			else 
    				l = m + 1;
    		}
    		else if( A[l] > A[m] ){
    			if( A[m] < target && target <= A[r])
    				l = m + 1;
    			else 
    				r = m - 1;
    		}
    		else 
    			l++;
    	}
    	return false;
    }
}
