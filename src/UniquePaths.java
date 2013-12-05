
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
}
