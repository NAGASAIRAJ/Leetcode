
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	int container, max = 0, start = 0, end = height.length - 1;
    	
    	while( start < end ) {
    		container = (end - start) * Math.min(height[start], height[end]);
    		if( container > max )
    			max = container;
    		if( height[start] < height[end] )
    			start++;
    		else 
    			end--;
    	}
    	
    	return max;
    }
}
