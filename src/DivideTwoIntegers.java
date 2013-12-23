
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		if( dividend == 0 || divisor == 1)
			return dividend;
		int sign = 1;
		if( dividend < 0 )
			sign *= (-1);
		if( divisor < 0 )
			sign *= (-1);
		long divid = Math.abs((long)dividend);
		long divis = Math.abs((long)divisor);
		long[] a = new long[32];
		int i = 0;
		
		while( divis > 0 && divis <= divid ) {
			a[i] = divis;
			divis = divis << 1;
			i++;
		}
		
		i--;
		long res = 0;
		
		while( 0 < divid && 0 <= i ) {
			if( a[i] <= divid ) {
				divid = divid - a[i];
				res = res + (1 << i);
			}
			i--;
		}
		
		return (int)(res * sign);
	}
}
