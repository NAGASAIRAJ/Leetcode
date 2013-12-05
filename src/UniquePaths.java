
public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	int paths[][] = new int[m+2][n+2];
    	for( int i = 0; i < m+2; i++ )
    		paths[i][n+1] = 0;
    	for( int i = 0; i < n+2; i++ )
    		paths[m+1][i] = 0;
    	paths[m][n+1] = 1;
    	for( int i = m; i >= 1; i-- ) {
    		for( int j = n; j >= 1; j-- ) {
    			paths[i][j] = paths[i+1][j] + paths[i][j+1];
    		}
    	}
    	return paths[1][1];
    }
    
    public int uniquePaths2(int m, int n) {
    	int paths[][] = new int[m+2][n+2];
    	for( int i = 0; i < m+2; i++ ) {
    		for( int j = 0; j < n+2; j++ )
    			paths[i][j] = -1;
    	}
    	return count_path(1, 1, m, n, paths);
    }
    
    public int count_path(int r, int c, int m, int n, int[][] paths) {
    	if( r > m || c > n )	return 0;
    	if( r == m && c == n )	return 1;
    	if( paths[r+1][c] == -1 )
    		paths[r+1][c] = count_path(r+1, c, m, n, paths);
    	if( paths[r][c+1] == -1 )
    		paths[r][c+1] = count_path(r, c+1, m, n, paths);
    	return  (paths[r+1][c] + paths[r][c+1]);
    }
}
