
public class ClimbingStairs {
    public static int climbStairs(int n) {
    	if( n == 0 || n == 1 )
    		return 1;
    	if( n == 2 ) 
    		return 2;
    	int[] tmp = new int[n];
    	tmp[0] = 1;
    	tmp[1] = 2;
    	for( int i = 2; i < n; i++ )
    		tmp[i] = tmp[i-1] + tmp[i-2];
    	return tmp[n-1];
    }

    public static int climbStairs_recursion(int n) {
    	if( n == 0 || n == 1 )
    		return 1;
    	if( n == 2 ) 
    		return 2;
    	
    	return climbStairs_recursion(n-1) + climbStairs_recursion(n-2);
    }
    
    public static void main(String[] args) {
    	System.out.println("Climb 4 stairs ways in iterative: " + climbStairs(4));
    	System.out.println("Climb 4 stairs ways in recusive: " + climbStairs_recursion(4));
    }
}
