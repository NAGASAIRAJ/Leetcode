
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if( len1 != len2 )	return false;
		int[] count = new int[26];
		for( int i = 0; i < len1; i++ )
			count[s1.charAt(i) - 'a']++;
		for( int i = 0; i < len2; i++ )
			count[s2.charAt(i) - 'a']--;
		for( int i = 0; i < 26; i++ ) {
			if( count[i] != 0 )
				return false;
		}
		if( len1 == 1 && len2 == 1 )
			return true;
		for( int i = 1; i < len1; i++ ) {
			boolean result = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
					isScramble(s1.substring(i), s2.substring(i));
			result = result || (isScramble(s1.substring(0, i), s2.substring(len2 - i)) &&
								isScramble(s1.substring(i), s2.substring(0, len2 - i)));
			if( result )	return result;
		}
		return false;
	}

}
