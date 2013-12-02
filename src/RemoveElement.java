
public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        if( A.length == 0 ) return 0;
        if( A.length == 1 && A[0] == elem ) {
        	A[0] = 0;
        	return 0;
        }
        int current = 0;
        for( int i = 0; i < A.length; i++ ) {
        	if( A[i] == elem )
        		continue;
        	A[current] = A[i];
        	current++;
        }
        return current;
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
