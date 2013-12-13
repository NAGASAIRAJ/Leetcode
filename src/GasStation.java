
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int CurSum = 0, TotalCost = 0, index = -1;
		for( int i = 0; i < gas.length; i++ ) {
			CurSum += (gas[i] - cost[i]);
			TotalCost += (gas[i] - cost[i]);
			if( CurSum < 0 ) {
				index = i;
				CurSum = 0;
			}
		}
		if( TotalCost >= 0 )
			return (index + 1);
		else 
			return -1;	
    }
}
