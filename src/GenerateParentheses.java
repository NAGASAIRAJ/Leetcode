import java.util.ArrayList;


public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> results = new ArrayList<String>();
    	if( n <= 0 ) return results;
    	generateParenthesis(n, n, "", results);
    	return results;
    }
    public void generateParenthesis(int left, int right, 
    		String cur, ArrayList<String> results) {
    	if( right == 0 ) {
    		results.add(cur);
    		return;
    	}
    	if( left > 0 ) {
    		cur += "(";
			generateParenthesis(left-1, right, cur, results);
    		if( left < right ) {
    			cur += ")";
    			generateParenthesis(left, right-1, cur, results);
    		}    		
    	}
    	else {
    		while( right > 0 ) {
    			cur += ")";
    			right--;
    		}
    		results.add(cur);
    	}
    }
}
