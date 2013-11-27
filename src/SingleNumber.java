
public class SingleNumber {
    public static int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	int result = A[0];    	
    	for( int i = 1; i < A.length; i++ ) 
    		result ^= A[i];
        return result;
    }
	
	public static void main(String[] args) {
		int[] test = {1, 2, 1};
		int[] test2 = {2, 2, 1};
		int[] test3 = {2, 2, 3, 1, 3};
		int[] test4 = {3, 1, 2, 2, 3};
		
		System.out.println("Unique number in test1: " + singleNumber(test));
		System.out.println("Unique number in test2: " + singleNumber(test2));
		System.out.println("Unique number in test3: " + singleNumber(test3));
		System.out.println("Unique number in test4: " + singleNumber(test4));		
	}	

}
