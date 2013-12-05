
public class RotateImage {
    public void rotate(int[][] matrix) {
    	int len = matrix.length;
    	if( len == 0 )	return;
    	
    	for( int i = 0; i < len - 1; i++ ) {
    		for( int j = 0; j < len - i; j++ )
    			swap(matrix, i, j, len-1-j, len-1-i); 
    	}
    	for( int i = 0; i < len/2; i++ ) {
    		for( int j = 0; j < len; j++ )
    			swap(matrix, i, j, len-1-i, j); 
    	}    	
    }
    public void swap(int[][] matrix, int i, int j, int m, int n) {
    	int tmp = matrix[i][j];
    	matrix[i][j] = matrix[m][n];
    	matrix[m][n] = tmp;
    }
}
