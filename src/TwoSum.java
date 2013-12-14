import java.util.Arrays;


public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if( numbers.length == 0 )
			return new int[2];
		Arrays.sort(numbers);
		
		int l = 0, r = numbers.length - 1;
		while( l < r ) {
			if( numbers[l] + numbers[r] == target )
				return new int[]{l, r};
			else if( numbers[l] + numbers[r] < target )
				l++;
			else
				r--;
		}
		
		return new int[2];
	}
}
