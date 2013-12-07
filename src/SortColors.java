
public class SortColors {
    public void sortColors(int[] A) {
    	int len = A.length;
    	if( len == 0 ) return;
    	int i = 0, RedIndex = 0, BlueIndex = len - 1;
    	while( i < BlueIndex + 1 ) {
    		if( A[i] == 0 ) {
    			swap(RedIndex, i, A);
    			RedIndex++;
    			i++;
    		}
    		else if( A[i] == 2 ) {
    			swap(i, BlueIndex, A);
    			BlueIndex--;
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
