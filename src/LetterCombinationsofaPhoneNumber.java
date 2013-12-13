import java.util.ArrayList;


public class LetterCombinationsofaPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> coms = new ArrayList<String>();
    	StringBuilder com = new StringBuilder();
    	String[] board = new String[] {" ", "1", "abc", "def", 
    									"ghi", "jkl", "mno", "pqrs", 
    									"tuv", "wxyz"};
    	DigitToLetters(0, digits, board, com, coms);
    	return coms;
    }
    private void DigitToLetters(int depth, String digits, String[] board,  
    							StringBuilder com, ArrayList<String> coms) {
    	if( depth == digits.length() ) {
    		coms.add(com.toString());
    		return;
    	}
    	String s = board[digits.charAt(depth) - '0'];
    	for( int i = 0; i < s.length(); i++ ) {
    		com.append(s.charAt(i));
    		DigitToLetters(depth + 1, digits, board, com, coms);
    		com.deleteCharAt(depth);
    	}
    }
}
