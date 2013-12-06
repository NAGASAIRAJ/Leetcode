import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int row = matrix.length;
		if( row == 0 )	return result;
		int col = matrix[0].length;
		if( col == 0 ) 	return result;
		int start = 0; 
		while( start * 2 < row && start * 2 < col ) {
			ReadMatrixInSpiralWay(row, col, start, result, matrix);
			start++;
		}
		return result;
    }
	public void ReadMatrixInSpiralWay(int row, int col, int start, ArrayList<Integer> result, 
										int[][] matrix) {
		int endX = col - 1 - start;
		int endY = row - 1 - start;
		for( int i = start; i <= endX; i++ )
			result.add(matrix[start][i]);
		if( start < endY ) {
			for( int i = start + 1; i <= endY; i++ )
				result.add(matrix[i][endX]);
		}
		if( start < endX && start < endY ) {
			for( int i = endX - 1; i >= start; i-- )
				result.add(matrix[endY][i]);			
		}
		if( start < endX && start < endY - 1 ) {
			for( int i = endY - 1; i > start; i-- )
				result.add(matrix[i][start]);
		}
	
	}
}
