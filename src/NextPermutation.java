
public class NextPermutation {
    public void nextPermutation(int[] num) {
    	int index = -1; 
    	for( int i = num.length - 1; i > 0; i-- ) {
    		if( num[i - 1] < num[i] ) {
    			index = i;
    			break;
    		}
    	}
    	if( index == -1 )
    		ReverseArray(0, num.length - 1, num);
    	else {
    		int BiggerIndex = FindBig(num[index - 1], index, num);
    		swap(BiggerIndex, index - 1, num);
    		ReverseArray(index, num.length - 1, num);
    	}
    }
    private int FindBig(int sentinal, int index, int[] num) {
    	int BigIndex = index;
    	int BigValue = num[index];
    	for( int i = index + 1; i < num.length; i++ ) {
    		if( sentinal < num[i] && num[i] <= BigValue ) {
    			BigValue = num[i];
    			BigIndex = i;
    		}
    	}
    	return BigIndex;
    }
    private void ReverseArray(int start, int end, int[] num) {
    	while( start < end ) {
    		swap(start, end, num);
    		start++;
    		end--;
    	}
    }
    private void swap(int m, int n, int[] num) {
    	int tmp = num[m];
    	num[m] = num[n];
    	num[n] = tmp;
    }
}
