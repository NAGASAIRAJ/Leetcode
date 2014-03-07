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
	
	public int largestRectangleArea2(int[] height) {
		int maxArea = 0;
		int len = height.length;
		int[] tmpHeight = new int[len + 1];
		int[] leftExpand = new int[len + 1];
		int[] rightExpand = new int[len + 1];
		for (int i = 0; i < len; i++) {
			tmpHeight[i] = height[i];
			leftExpand[i] = 0;
			rightExpand[i] = len - 1;
		}
		tmpHeight[len] = -1;
		leftExpand[len] = 0;
		rightExpand[len] = len -1;
		for (int i = 1; i <= len; i++) {
			if (tmpHeight[i - 1] < tmpHeight[i]) {
				leftExpand[i] = i;
			} else {
				rightExpand[i - 1] = i - 1;
				int j = leftExpand[i - 1];
				while (j > 0) {
					if (tmpHeight[j - 1] < tmpHeight[i]) {
						break;
					} else {
						rightExpand[j - 1] = i - 1;
						j = leftExpand[j - 1];
					}
				}
				leftExpand[i] = j;
			}
		}
		for (int i = 0; i < len; i++) {
			maxArea = Math.max(maxArea, 
					(rightExpand[i] - leftExpand[i] + 1) * height[i]);
		}
		return maxArea;
	}
}
