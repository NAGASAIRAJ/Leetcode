
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
    	if( A.length == 0 ) return -1;
    	if( A.length == 1 ) {
    		if( A[0] == target ) 
    			return 0;
    		else 
    			return -1;
    	}
    	int l = 0, r = A.length - 1, m = 0;
    	while( l <= r ) {
    		m = (l + r) / 2;
    		if( A[m] == target )
    			return m;
    		if( A[l] <= A[m] ) { // left half is sorted
    			if( A[l] <= target && target < A[m] )
    				r = m - 1;
    			else 
    				l = m + 1;
    		}
    		else { // right half is sorted
    			if( A[m] < target && target <= A[r])
    				l = m + 1;
    			else 
    				r = m - 1;
    		}
    	}
    	return -1;
    }
}
