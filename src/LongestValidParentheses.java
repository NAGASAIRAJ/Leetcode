import java.util.Stack;


public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int max = 0;
		Stack<Node> stack = new Stack<Node>();
		stack.push(new Node(')', -1));
		for( int i = 0; i < s.length(); i++ ) {
			char c = s.charAt(i);
			if( c == '(' ) 
				stack.push(new Node(c, i));
			else {
				Node top = stack.peek();
				if( top.c == '(' ) {
					stack.pop();
					max = Math.max(max, i - stack.peek().i);
				}
				else
					stack.push(new Node(c, i));
			}
		}
		return max;
	}
}

class Node {
	char c;
	int i;
	public Node(char c, int i) {
		this.c = c;
		this.i = i;
	}
}