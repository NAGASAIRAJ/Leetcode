import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int num_count = 1 << n;
    	for( int i = 0; i < num_count; i++ )
    		result.add(i^(i>>1));
    	return result;
    }
}
