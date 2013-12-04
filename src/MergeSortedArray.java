
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
    	int A_cur = m - 1;
    	int B_cur = n - 1;
    	int result_cur = m + n - 1; 
    	while( A_cur >= 0 && B_cur >= 0 ) {
    		if( A[A_cur] > B[B_cur] ) {
    			A[result_cur] = A[A_cur];
    			A_cur--;
    		}
    		else {
    			A[result_cur] = B[B_cur];
    			B_cur--;
    		}
    		result_cur--;
    	}
    	if( B_cur >= 0 ) {
    		for( int i = B_cur; i >= 0; i-- ) {
    			A[result_cur] = B[i]; // use i rather than B_cur
    			result_cur--;
    		}
    	}    	
    }
}
