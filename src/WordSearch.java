
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int WordLen = word.length();
		if( WordLen == 0 )	return true;
		int r = board.length;
		if( r == 0 )	return false;
		int c = board[0].length;
		for( int i = 0; i < r; i++ ) {
			for( int j = 0; j < c; j++ ) {
				if( board[i][j] == word.charAt(0) ) {
					boolean found = FindWord(board, word, new boolean[r][c], 0, i, j);
					if( found )	return found;
				}
			}
		}
		return false;
    }
	private boolean FindWord(char[][] board, String word, boolean[][] visited, 
			                 int depth, int i, int j) {
		if( depth == word.length() )	return true;
		if( i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
				(visited[i][j] == true) || (word.charAt(depth) != board[i][j]) )
			return false;
		visited[i][j] = true;
		// top, down, left, right
		return FindWord(board, word, visited, depth + 1, i - 1, j) ||
				FindWord(board, word, visited, depth + 1, i + 1, j) ||
				FindWord(board, word, visited, depth + 1, i, j - 1) ||
				FindWord(board, word, visited, depth + 1, i, j + 1);
	}
}
