
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
    	int r = grid.length;
    	int c = grid[0].length;
    	int[][] paths = new int[r+2][c+2];
    	for( int i = r; i < r + 2; i++ )
    		paths[i][c+1] = Integer.MIN_VALUE;
    	for( int i = c; i < c + 2; i++ )
    		paths[r+1][i] = Integer.MIN_VALUE;
    	paths[r][c+1] = 0;
    	for( int i = r; i > 0; i-- ) {
    		for( int j = c; j > 0; j-- ) 
    			paths[i][j] = grid[i-1][j-1] + Math.min(paths[i+1][j], paths[i][j+1]);
    	}
    	return paths[1][1];
    }
}
