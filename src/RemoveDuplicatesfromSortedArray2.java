
public class RemoveDuplicatesfromSortedArray2 {
	public int removeDuplicates(int[] A) {
		if( A.length == 0 || A.length == 1 ) 
			return A.length;
		int len = 1, start = 0, end = 0;
		for( int i = 1; i < A.length; i++ ) {
			if( A[i-1] == A[i] ) {
				end++;
				if( end - start < 2 ) {
					A[len++] = A[i];
				}
				continue;
			}
			else {
				A[len++] = A[i];
				start = i;
				end = i;
			}
		}
		return len;
    }
}
