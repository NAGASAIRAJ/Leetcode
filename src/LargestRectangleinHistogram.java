import java.util.Stack;


public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> st = new Stack<Integer>();
		int cur = 0, area = 0;
		
		while( cur < height.length ) {
			if( st.isEmpty() || height[cur] >= height[st.peek()] )
				st.push(cur++);
			else {
				int top = st.pop();
				area = Math.max(area, height[top] * (st.isEmpty()? cur : 
													 (cur - st.peek() - 1) ));
			}
		}
		
		while( !st.isEmpty() ) {
			int top = st.pop();
			area = Math.max(area,  height[top] * (st.isEmpty()? cur :
													(cur - st.peek() - 1)));
		}
		
		return area;
    }
}
