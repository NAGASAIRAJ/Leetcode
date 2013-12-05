import java.util.ArrayList;


public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> results = new ArrayList<String>();
    	StringBuffer tmp = new StringBuffer();
    	generateParenthesis(n, n, tmp, results);
    	return results;
    }
    public void generateParenthesis(int left, int right, 
    		StringBuffer cur, ArrayList<String> results) {
    	if( right == 0 ) {
    		results.add(cur.toString());
    		return;
    	}
    	if( left > 0 ) {
    		cur.append("(");
			generateParenthesis(left-1, right, cur, results);
    		if( left < right ) {
    			cur.append(")");
    			generateParenthesis(left, right-1, cur, results);
    		}    		
    	}
    	else {
    		while( right > 0 ) {
    			cur.append(")");
    			right--;
    		}
    		results.add(cur.toString());
    	}
    }
}
