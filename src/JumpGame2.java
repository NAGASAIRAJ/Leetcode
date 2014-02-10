
public class JumpGame2 {
    public int jump(int[] A) {
    	if( A.length <= 1 )	return 0;
    	int len = A.length;
    	int CurMax = 0, NextMax = 0, JumpSteps = 0;
    	for( int i = 0; i < len; i++ ) {
    		if( CurMax < i ) { // cannot reach current index i
    			CurMax = NextMax; 
    			JumpSteps++; // it takes one step to reach i first, then continue
    		}
    		NextMax = Math.max(NextMax, i + A[i] );
    	}
    	return JumpSteps;
    }
}
