
public class Sqrt {
	public int sqrt(int x) {
		if( x == 0 || x == 1 )
			return x;
		int start = 0, end = x;
		
		while( start <= end ) {
			int mid = start + (end - start) / 2;
			if( mid == x / mid )
				return mid;
			else if( mid < x / mid )
				start = mid + 1;
			else 
				end = mid - 1;
		}
			
		return (start + end) / 2;
	}
}
