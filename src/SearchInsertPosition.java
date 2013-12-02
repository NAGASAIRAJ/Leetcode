
public class SearchInsertPosition {
    public static int searchInsert(int[] A, int target) {
    	if( A.length == 0 ) return 0;
    	if( target < A[0] ) return 0;
    	if( target > A[A.length-1] ) return A.length;
    	int start = 0, end = A.length-1, mid = 0;
    	while( start <= end ) {
    		mid = (start + end) / 2;
    		if( A[mid] == target ) return mid;
    		else if( A[mid] < target ) start = mid + 1;
    		else end = mid - 1;
    	}
    	
    	return (start+1);
    }
    
	public static void main(String[] args) {
		int[] test = {1, 3, 5, 6};
		System.out.println("Insert Position in test case 1: " + searchInsert(test, 5));		
	}
}
