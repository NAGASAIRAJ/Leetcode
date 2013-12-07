
public class JumpGame2 {
    public int jump(int[] A) {
    	if( A.length <= 1 )	return 0;
    	int len = A.length;
    	int CurMax = 0, NextMax = 0, JumpSteps = 0;
    	for( int i = 0; i < len; i++ ) {
    		if( CurMax < i ) {
    			CurMax = NextMax; 
    			JumpSteps++;
    		}
    		NextMax = Math.max(NextMax, i + A[i] );
    	}
    	return JumpSteps;
    }
}
