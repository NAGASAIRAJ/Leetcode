import java.util.ArrayList;

	
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
		ArrayList<String> partition = new ArrayList<String>();
		CreatePartition(0, s, partition, partitions);
		return partitions;
    }
	private void CreatePartition(int depth, String s, ArrayList<String> partition, 
									ArrayList<ArrayList<String>> partitions) {
		if( depth == s.length() ) {
			ArrayList<String> TmpPar = new ArrayList<String>();
			TmpPar.addAll(partition);
			partitions.add(TmpPar);
			return;
		}
		for( int i = depth; i < s.length(); i++ ) {
			if( IsPalidrome(depth, i, s) ) {
				partition.add(s.substring(depth, i + 1));
				CreatePartition(i + 1, s, partition, partitions);
				partition.remove(partition.size() - 1);
			}
		}
	}
	private boolean IsPalidrome(int start, int end, String s) {
		while( start < end ) {
			if( s.charAt(start) != s.charAt(end) )
				return false;
			start++;
			end--;
		}
		
		return true;
	}
	
}
