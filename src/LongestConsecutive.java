
public class LongestConsecutive {
	public static int longestConsecutive(int[] num) {
		java.util.HashMap<Integer, Integer> nums = new java.util.HashMap<Integer, Integer>();
		for( int i = 0; i < num.length; i++)
			nums.put(num[i], i);
		boolean[] visited = new boolean[num.length];
		int max_len = Integer.MIN_VALUE;
		int len, index; 
		for( int i = 0; i < num.length; i++) {
			if(visited[i]) continue;
			index = num[i];
			len = 0;
			while(nums.containsKey(index)) {
				visited[nums.get(index)] = true;
				index--;
				len++;
			}
			
			index = num[i] + 1;
			
			while(nums.containsKey(index)) {
				visited[nums.get(index)] = true;
				index++;
				len++;
			}
			
			if( len > max_len )
				max_len = len;
		}
		return max_len;
	}
	

	public static void main(String[] args) {
		int[] LCS = {100, 4, 200, 1, 3, 2};
		System.out.println("Longest Consecutive Sequence length: " + longestConsecutive(LCS));
	}
}
