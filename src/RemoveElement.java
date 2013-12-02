
public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        if( A.length == 0 ) return 0;
        if( A.length == 1 && A[0] == elem ) {
        	A[0] = 0;
        	return 0;
        }
        int available = 0, current = 0, next = 0, len = 0;
        while( current < A.length ) {
        	next = current + 1;
        	if( A[current] == elem ) {
        		while( next < A.length && A[next] == elem )
        			next++;
        		if( next < A.length ) {
        			A[available] = A[next];
        			available = current + 1;
        			current = next + 1;       			
        		}
        		else {
        			for( int i = current; i < A.length; i++ )
        				A[i] = 0;
        			break;
        		}
        	}
        	else 
        		current++;
			len++; 
        }
        return len;
    }
    
    public static void main(String[] args) {
		int[] test = {1, 3, 5, 6};
		int[] test2 = {1, 1, 2};
		int[] test3 = {1, 1, 1, 2};
		int[] test4 = {1, 1};
		int[] test5 = {1, 2, 3, 4};
		System.out.println("No Duplicate Lenth in test case 1: " + removeElement(test, 2));
		System.out.println("No Duplicate Lenth in test case 2: " + removeElement(test2, 1));
		System.out.println("No Duplicate Lenth in test case 3: " + removeElement(test3, 1));
		System.out.println("No Duplicate Lenth in test case 4: " + removeElement(test4, 1));
		System.out.println("No Duplicate Lenth in test case 5: " + removeElement(test5, 1));
    }
}
