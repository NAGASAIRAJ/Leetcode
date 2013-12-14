import java.util.HashMap;


public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if( numbers.length == 0 )
			return new int[2];
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		for( int i = 0; i < numbers.length; i++ )
			nums.put(numbers[i], i);
		
		for( int i = 0; i < numbers.length; i++ ) {
			int searched = target - numbers[i];
			if( nums.containsKey(searched) )
				return new int[]{i + 1, nums.get(searched) + 1};
		}
				
		return new int[2];
	}
}
