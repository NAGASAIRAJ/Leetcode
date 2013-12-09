import java.util.ArrayList;


public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if( triangle == null || triangle.size() == 0 )
    		return 0;
    	int r = triangle.size();
    	int[] sums = new int[r];
    	int c;
    	for( int i = r - 1; i >= 0; i-- ) {
    		c = triangle.get(i).size();
    		for( int j = 0; j < c; j++ ) {
    			if( i == r - 1 ) {
    				sums[j] = triangle.get(i).get(j);
    				continue;
    			}
    			sums[j] = Math.min(sums[j], sums[j+1]) + 
    					  triangle.get(i).get(j);
    		}
    	}
    	return sums[0];
    }
}
