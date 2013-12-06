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
    	if( left == 0 ) {
    		while( right > 0 ) {
    			cur += ")";
    			right--;
    		}
    		results.add(cur);
    		return;
    	}    	   		
		
    	generateParenthesis(left-1, right, cur + "(", results);
    	
    	if( left < right )     			
    			generateParenthesis(left, right-1, cur + ")", results);    		    		    	
    }
}
