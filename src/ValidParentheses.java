
public class ValidParentheses {
    public boolean isValid(String s) {
    	java.util.Stack<Character> st = new java.util.Stack<Character>();
    	int len = s.length();
    	
    	for( int i = 0; i < len; i++ ) {
    		if( st.isEmpty() ) {
    			char c = s.charAt(i);
    			st.push(c);
    		}
    		else {
    			char top = st.peek();
    			char c = s.charAt(i);
    			if( match(top, c) )
    				st.pop();
    			else
    				st.push(c);
    		}
    	}
    	if( st.isEmpty() )
    		return true;
    	else 
    		return false;
    }
    private boolean match(char l, char r) {
    	if( l == '(' && r == ')' )
    		return true;
    	else if( l == '{' && r == '}' )
    		return true;
    	else if ( l == '[' && r == ']' )
    		return true;
    	else 
    		return false;
    }
}
