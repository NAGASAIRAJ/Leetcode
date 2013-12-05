
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int r = obstacleGrid.length;
    	int c = obstacleGrid[0].length;
    	int[][] paths = new int[r+2][c+2];
    	for( int i = 0; i < r + 2; i++ ) 
    		paths[i][c+1] = 0;
    	for( int i = 0; i < c + 2; i++ )
    		paths[r+1][c] = 0;
    	paths[r][c+1] = 1; 
    	for( int i = r; i >= 1; i-- ) {
    		for( int j = c; j >= 1; j-- ) {
    			if( obstacleGrid[i-1][j-1] == 1 ) {
    				paths[i][j] = 0; 
    				continue;
    			}
    			paths[i][j] = paths[i+1][j] + paths[i][j+1];    			    				
    		}
    	}
    	return paths[1][1];
    }
}
