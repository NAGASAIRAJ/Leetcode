
public class SingleNumber {
    public static int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	int half1 = A[A.length/2];
    	int half2 = 0;
    	for( int i = 0; i < A.length/2; i++ ) {
    		half1 += A[i];
    		half2 += A[A.length-1-i];
    	}        
        return (half1 - half2);
    }
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3};
		System.out.println("Unique number: " + singleNumber(test));
	}	

}
