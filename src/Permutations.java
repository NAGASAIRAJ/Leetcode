import java.util.ArrayList;


public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	permutation(num, 0, num.length, result);

        ArrayList<Integer> inputDigits = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            inputDigits.add(num[i]);
        }
        ArrayList<Integer> result1 = new ArrayList<Integer>(permutationsOf(inputDigits));

    	return result;
    }
    public void permutation(int[] num, int depth, int len, ArrayList<ArrayList<Integer>> result ) {
    	if( depth == len ) {
    		ArrayList<Integer> num_tmp = new ArrayList<Integer>();
    		for( int i = 0; i < len; i++ ) 
    			num_tmp.add(num[i]);
    		result.add(num_tmp);
    	}
    	
    	for( int i = depth; i < len; i++ ) {
    		int tmp = num[i];
    		num[i] = num[depth];
    		num[depth] = tmp;
    			
    		permutation(num, depth+1, len, result);
    			
    		tmp = num[i];
    		num[i] = num[depth];
    		num[depth] = tmp;
    	}    	
    }
    public static ArrayList<Integer> permutationsOf(ArrayList<Integer> inputDigits) {
      if (inputDigits.size() == 1) {
        return inputDigits;
      }
      ArrayList<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < inputDigits.size(); i++) {
        Integer digit = inputDigits.get(i);
        ArrayList<Integer> restDigits = new ArrayList<Integer>(inputDigits);
        restDigits.remove(digit);
        ArrayList<Integer> permutationOfRestOfDigits = new ArrayList<Integer>(permutationsOf(restDigits));
        for (int j = 0; j < permutationOfRestOfDigits.size(); j++) {
          result.add(permutationOfRestOfDigits.get(j) * 10 + digit);
        }
     }
   
     return result;
   }
}