
public class ImplementstrStr {
	public static String strStr(String haystack, String needle) {
		int NeedleLen = needle.length();
		int HaystackLen = haystack.length();
		if( HaystackLen < NeedleLen )
			return null;
		if( NeedleLen == 0 )
			return haystack;
		int i;
		for( i = 0; i < HaystackLen - NeedleLen + 1; ) {
			int j;
			for( j = 0; j < NeedleLen; ) {
				if( needle.charAt(j) == haystack.charAt(i) ) {
					i++;
					j++;
				}
				else 
					break;
			}
			if( j == NeedleLen ) {
				i = i - j;
				return haystack.substring(i, HaystackLen);
			}
			else
				i = i - j + 1;				
		}
		return null;
	}
}
