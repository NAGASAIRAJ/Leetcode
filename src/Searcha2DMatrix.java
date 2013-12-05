
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {		  		
		int r = matrix.length - 1; 
		int c = 0; 
		while( r >= 0 && c < matrix[0].length ) {
			if( matrix[r][c] == target ) 
				return true;
			else if( matrix[r][c] < target )
				c++;
			else
				r--;			
		}
		return false;
    }
}
