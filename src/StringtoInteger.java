
public class StringtoInteger {
	public int atoi(String str) {
		if( str == null || str.length() == 0 )
			return 0;
		String TmpStr = str.trim();
		boolean IsPositive = true;
		if( TmpStr.charAt(0) == '-' ) { 
			IsPositive = false;				
			TmpStr = TmpStr.substring(1);
		} 
		else if( TmpStr.charAt(0) == '+' )
			TmpStr = TmpStr.substring(1);
		long res = 0;
		for( int i = 0; i < TmpStr.length(); i++ ) {
			char c = TmpStr.charAt(i);
			if( '0' <= c && c <= '9' )
				res = res * 10 + (c - '0');
			else 
				break;
		}
		if( !IsPositive )
			res *= (-1);
		if( res < Integer.MIN_VALUE )
			res = Integer.MIN_VALUE;
		if( res > Integer.MAX_VALUE )
			res = Integer.MAX_VALUE;
		return (int)res;
    }
}
