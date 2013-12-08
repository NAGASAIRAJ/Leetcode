
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int idx = BinarySearch(A, target);
        if( idx == -1 )
        	return (new int[]{-1, -1});
        else {
        	int l = idx, r = idx;
        	
        	while( l >= 0 && A[l] == target )
        		l--;
        	l++;
        	
        	while( r < A.length && A[r] == target)
        		r++;
        	r--;
        	return (new int[]{l, r});
        }
    }
    private int BinarySearch(int[] A, int target) {
    	int mid, l = 0, r = A.length - 1;
    	while( l <= r ) {
    		mid = (l + r) / 2;
    		if( A[mid] == target )
    			return mid;
    		else if( A[mid] < target )
    			l = mid + 1;
    		else
    			r = mid - 1; 
    	}
    	return -1;
    }
}
