import java.util.Arrays;


public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
    	if( num.length == 0 )	return target;
    	int ClosestSum = 0;
    	if( num.length < 4 ) {    		
    		for( int i = 0; i < num.length; i++ )
    			ClosestSum += num[i];
    		return ClosestSum;
    	}
    	int MinDiffWithTarget = Integer.MAX_VALUE;
    	Arrays.sort(num);
    	int start, end, CurSum, len = num.length;
    	for( int i = 0; i < len; i++ ) {
    		start = i + 1;
    		end = len - 1;
    		while( start < end ) {
    			CurSum = num[i] + num[start] + num[end];
    			if( CurSum == target ) {
    				MinDiffWithTarget = 0;
    				ClosestSum = target;
    				start++;
    				end--;
    				return ClosestSum;
    			}
    			else if( CurSum < target ) {
    				if( Math.abs(CurSum - target) < MinDiffWithTarget ) {
    					MinDiffWithTarget = Math.abs(CurSum - target);
    					ClosestSum = CurSum;
    				}    					
    				start++;
    			}
    			else {
    				if( Math.abs(CurSum - target) < MinDiffWithTarget ) {
    					MinDiffWithTarget = Math.abs(CurSum - target);
    					ClosestSum = CurSum;
    				}
    				end--;
    			}
    		}
    	}
    	return ClosestSum;
    }
}
