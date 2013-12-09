import java.util.ArrayList;


public class NQueens {
	public static ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int depth = 0;
		int[] rows = new int[n];
		for( int i = 0; i < n; i++ )
			rows[i] = n + 1;
		dfs(depth, rows, n, result);
		return result;			
	}
	public static void dfs(int depth, int[] rows, int n, ArrayList<String[]> result) {
		if( depth == n ) {
			String[] s = new String[n];
			for( int i = 0; i < n; i++ ) {
				int m = rows[i];
				StringBuilder tmp = new StringBuilder();
				for( int j = 0; j < n; j++ ) {
					if( j == m ) {
						tmp.append("Q");
						continue;
					}
					tmp.append(".");
				}
				s[i] = tmp.toString();
			}
			result.add(s);
			return;
		}
		for( int i = 0; i < n; i++ ) {
			rows[depth] = i;
			if( IsValid(rows, depth) )
				dfs(depth + 1, rows, n, result);
		}
	}
	public static boolean IsValid(int[] rows, int depth) {
		for( int i = 0; i < depth; i++ ) {
			if( rows[i] == rows[depth] ||
					Math.abs(rows[i] - rows[depth]) == Math.abs(i - depth) )
				return false;
		}
		return true;
	}
}
