
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] A) {
        if( A.length == 0 || A.length == 1 ) return A.length;
        int current, previous = 0, NoDuplicateLen = 1;
        for( int i = 1; i < A.length; i++ ) {
        	current = i;
        	if( A[previous] != A[current] ) {
        		if( previous + 2 < current ) {
        			for( int j = previous + 2; j <= current; j++ )
        				A[j] = 0;
        		}
        		A[previous+1]  = A[current];
        		previous++;
        		NoDuplicateLen++;
        	}
        }
        return NoDuplicateLen;
    }
    
    public static void main(String[] args) {
		int[] test = {1, 3, 5, 6};
		int[] test2 = {1, 1, 2};
		System.out.println("No Duplicate Lenth in test case 1: " + removeDuplicates(test));
		System.out.println("No Duplicate Lenth in test case 2: " + removeDuplicates(test2));
    }
}
