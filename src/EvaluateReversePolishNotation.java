import java.util.Stack;


public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if( tokens == null || tokens.length == 0 )
			return 0;
		Stack<String> stack = new Stack<String>();
		int res = 0;
		String operators = "+-*/";
		for( String s : tokens ) {
			if( !operators.contains(s) )
				stack.push(s);
			else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int idx = operators.indexOf(s);
				switch(idx) {
					case 0: 
						stack.push(String.valueOf(a + b));
						break;
					case 1:
						stack.push(String.valueOf(b - a));
						break;
					case 2:
						stack.push(String.valueOf(a * b));
						break;
					case 3:
						stack.push(String.valueOf(b / a));
						break;						
				}
			}
		}
		res = Integer.valueOf(stack.pop());
		return res;
    }
}
