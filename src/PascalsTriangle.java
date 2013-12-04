import java.util.ArrayList;


public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if( numRows <= 0 )	return result;
    	ArrayList<Integer> first = new ArrayList<Integer>();
    	first.add(1);
    	result.add(first);
    	if( numRows == 1 ) return result;
    	ArrayList<Integer> second = new ArrayList<Integer>();
    	second.add(1);	second.add(1);
    	result.add(second);
    	if( numRows == 2 ) return result;
    	for( int i = 3; i <= numRows; i++ ) {
    		int resultSize = result.size();
    		ArrayList<Integer> previous = result.get(resultSize - 1);
    		ArrayList<Integer> current = new ArrayList<Integer>();
    		for( int j = 1; j <= i; j++ ) {
    			if( j== 1 || j == i ) {
    				current.add(1);
    			}
    			else {
    				int num = previous.get(j-2) + previous.get(j-1);
    				current.add(num);
    			}    				
    		}
    		result.add(current);
    	}
    	return result;
    }
}
