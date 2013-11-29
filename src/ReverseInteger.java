
public class ReverseInteger {
	public static int reverse(int x) {
		boolean isNegative = (x < 0)? true : false;
		int result = 0;
		int num = Math.abs(x);
		while( num != 0 ) {
			result = result * 10 + num % 10;
			num /= 10;
		}
		
		if( result < 0 ) return -1;
		else if ( isNegative ) result *= (-1);
		return result;
	}
	
	public static void main(String[] args) {
		int value = -1234;
		int value2 = 1000000003;
		int value3 = 100;
		System.out.println("Origin num: " + value + " and Reversed: " + reverse(value));
		System.out.println("Origin num: " + value2 + " and Reversed: " + reverse(value2));
		System.out.println("Origin num: " + value3 + " and Reversed: " + reverse(value3));
	}
}
