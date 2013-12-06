
public class SortColors {
    public void sortColors(int[] A) {
    	int len = A.length;
    	if( len == 0 ) return;
    	int i = 0, RedIndex = 0, BlueIndex = len - 1;
    	while( i < len ) {
    		if( A[i] == 0 ) {
    			if( i == 0 ) {
    				i++;
    				RedIndex++;
    			}
    			else if( A[RedIndex] != 0 ) {
    				swap(RedIndex, i, A);
    				RedIndex++;
    				if( i < RedIndex )
    					i = RedIndex;
    			}
    			else {
    				RedIndex++;
    				if( RedIndex >= len)	// [0, 0] case
    					return;
    			}
    		}
    		else if( A[i] == 2 ) {
    			if( i == A.length - 1 )
    				return;
    			else if( A[BlueIndex] != 2 ) {
    				swap(i, BlueIndex, A);
    				BlueIndex--;
    			}
    			else {
    				BlueIndex--;
    				if( BlueIndex < i )
    					return;
    			}
    		}
    		else 
    			i++;
    	}
    }
    public void swap(int m, int n, int[] nums) {
    	int tmp = nums[m];
    	nums[m] = nums[n];
    	nums[n] = tmp;
    }
}
