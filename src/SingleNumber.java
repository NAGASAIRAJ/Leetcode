
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
		System.out.println("Unique number: " + singleNumber(test));
	}	

}
