
public class Pow {
    public double pow(double x, int n) {
    	long tmp = n;
    	if( tmp >= 0 )
    		return power(x, tmp);
    	else
    		return 1.0 / power(x, -tmp);
    }
    private double power(double x, long n) {
    	if( n == 0 )	return 1;
    	if( n == 1 )	return x;
    	double result = power(x, n >> 1);
    	result *= result;
    	if( (n & 0x1) == 1 ) 
    		result *= x;
    	return result;
    }
}
