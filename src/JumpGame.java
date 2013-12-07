
public class JumpGame {
    public boolean canJump(int[] A) {
    	if( A.length == 0 )	return true;
    	int len = A.length;
    	int[] jump = new int[len];
    	jump[0] = 0;
    	for( int i = 1; i < len; i++ ) {
    		jump[i] = Math.max(jump[i-1], A[i-1]) - 1;
    		if( jump[i] < 0 )
    			return false;
    	}
    	return true;
    }
}
