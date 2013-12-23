
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int ALen = A.length;
		int BLen = B.length;
		if( (ALen + BLen) % 2 == 0 ) 
			return (GetKthElement(A, 0, ALen - 1, B, 0, BLen - 1, (ALen + BLen) / 2) +
					GetKthElement(A, 0, ALen - 1, B, 0, BLen - 1, (ALen + BLen) / 2 + 1)) / 2.0;
		else 
			return GetKthElement(A, 0, ALen - 1, B, 0, BLen - 1, (ALen + BLen) / 2 + 1);		
    }
	private int GetKthElement(int A[], int AStart, int AEnd, int B[], int BStart, int BEnd,
								int k) {
		if( AStart > AEnd )
			return B[BStart + (k - 1)];
		if( BStart > BEnd )
			return A[AStart + (k - 1)];
		int AMid = (AStart + AEnd) >> 1;
		int BMid = (BStart + BEnd) >> 1;
		int len = AMid - AStart + BMid - BStart + 2;
		if( len > k ) {
			if( A[AMid] < B[BMid] )
				return GetKthElement(A, AStart, AEnd, B, BStart, BMid - 1, k);
			else
				return GetKthElement(A, AStart, AMid - 1, B, BStart, BEnd, k);			
		}
		else {
			if( A[AMid] < B[BMid] )
				return GetKthElement(A, AMid + 1, AEnd, B, BStart, BEnd, k - (AMid - AStart + 1));
			else
				return GetKthElement(A, AStart, AEnd, B, BMid + 1, BEnd, k - (BMid - BStart + 1));
		}					
	}
}
