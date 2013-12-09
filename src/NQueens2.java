
public class NQueens2 {
	private static int SolNum;
	private static int upper; 
	public int totalNQueens(int n){
		SolNum = 0;
        upper = (1 << n) - 1 ;
        Queen(0, 0, 0);
        return SolNum;
    }
    
	// ld for left diagonal and rd for right diagonal
    private void Queen(int row, int ld, int rd){
         int pos, p;
         if(row != upper) {
             pos = upper & (~(row | ld | rd));	// available slot for Q
             while( pos != 0) { // "1" for available slot              
                 p = pos & (-pos); // from right to left, the first "1" in pos
                 // now occupy the most right available position
                 pos = pos - p;// now place Q，pos kind of like a available slot marker
                 Queen(row + p, (ld + p) << 1, (rd + p) >> 1);
             }
         }
         else 
        	 SolNum++;
    }
}
