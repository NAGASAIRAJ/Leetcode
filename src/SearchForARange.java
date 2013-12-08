
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
    
    public int[] searchRange2(int[] A, int target) {
    	int l = 0, r = A.length - 1;
    	int[] result = {-1, -1};
    	while( l < r ) { // lower bound in l
    		int mid = l + (r - l) / 2;
    		if( target <= A[mid] )
    			r = mid;
    		else 
    			l = mid + 1;    		
    	}
    	
    	if( A[l] == target )
    		result[0] = l;
    	else 
    		return result;
    	l = 0;
    	r = A.length;
    	
    	while( l < r) { // upper bound in r - 1
    		int mid = l + (r - l) / 2;
    		if( target >= A[mid] )
    			l = mid + 1;
    		else 
    			r = mid;    		
    		
    	}
    	
    	result[1] = r - 1;
    	return result;
    }
}
