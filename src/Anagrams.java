import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		Map<String, ArrayList<String>> SortedStrs = new HashMap<String, ArrayList<String>>();
		for( int i = 0; i < strs.length; i++ ) {
			String CurStr = strs[i];
			String SortedStr = StrSort(CurStr);
			if( SortedStrs.get(SortedStr) != null ) 
				SortedStrs.get(SortedStr).add(CurStr);
			else {
				ArrayList<String> StrList = new ArrayList<String>();
				StrList.add(CurStr);
				SortedStrs.put(SortedStr, StrList);
			}			
		}
		Iterator<ArrayList<String>> it = SortedStrs.values().iterator();
		
		while( it.hasNext() ) {
			ArrayList<String> StrList = it.next();
			if( StrList.size() > 1 )
				result.addAll(StrList);
		}
		
		return result;
    }
	private String StrSort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
