import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int num_count = 1 << n;
    	for( int i = 0; i < num_count; i++ )
    		result.add(i^(i>>1));
    	return result;
    }
    
    public ArrayList<Integer> grayCode2(int n) {    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	result.add(0);
    	if( n == 0 )     	
    		return result;
    	result.add(1);
    	if( n == 1 )     		
    		return result;
    	ArrayList<Integer> prev = grayCode2(n-1);
    	result.addAll(prev);
    	int top = 1 << n;
    	for( int i = 0; i < prev.size(); i++ )
    		result.add(top+prev.get(i));
    	return result;
    }
}
