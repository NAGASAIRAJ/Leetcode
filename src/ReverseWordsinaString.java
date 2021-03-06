import java.util.Stack;

public class ReverseWordsinaString {
	private static String reverse(String s) {
		StringBuilder tmp = new StringBuilder(s);
		tmp.reverse();
		return tmp.toString();
	}
	private static String reverse(String s, int start, int end) {
		String head = reverse(s.substring(start, end + 1));
		//System.out.println("Reversed partially: " + head + s.substring(end + 1));
		return head; 
	}
	
	private static String trimSpace(String s) {
		int spaceHeadIdx = 0;
		int spaceTailIdx = s.length() - 1;
		String tmpRes;
		String res = "";
		
		while (spaceHeadIdx < s.length() && s.charAt(spaceHeadIdx++) == ' ') { }
		
		while (spaceTailIdx >= 0 && s.charAt(spaceTailIdx--) == ' ') { }
		
		if (spaceTailIdx == s.length() - 1) {
			tmpRes = s.substring(spaceHeadIdx);
		}
		else {
			if (spaceTailIdx < spaceHeadIdx) {
				return "";
			}
			tmpRes =  s.substring(spaceHeadIdx, spaceTailIdx + 1);
		}
		
		for (int i = 0; i < tmpRes.length(); i++) {
			if (tmpRes.charAt(i) != ' ') { // character
				res += tmpRes.charAt(i);
			} else {
				if (i > 0 && tmpRes.charAt(i - 1) != ' ') { // the 1st whitespace 
					res += tmpRes.charAt(i);
				} else { // skip repeated whitespace
					continue; 
				}
			}				
		}
			
		return res;
	}
	
    public static String reverseWords(String s) {
        String res = "";
        if (s == " ")
    		return res;
    	int nonSpace = 0;
    	for (int i = 0; i < s.length(); i++) {
    	    if (s.charAt(i) != ' ') {
        	    nonSpace++;
    	    }
    	}
    	if (nonSpace == 0)
            return res;
        if (s.length() <= 1)
    		return s;
        String reversedWhole = reverse(s);
        System.out.println("Reversed whole: " + reversedWhole);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (reversedWhole.charAt(i) == ' ') {
        		if (start + 1 < i) {
        			res += reverse(reversedWhole, start, i - 1);
        		} else {
        			res += ("" + reversedWhole.charAt(start));
        		}
        		start = i + 1;
        		res += " ";
        	}
        }
        
        if (reversedWhole.charAt(s.length() - 1) != ' ') {
        	res += reverse(reversedWhole, start, s.length() - 1);
        } 
        System.out.println("Before trim: " + reversedWhole + ", len: " + reversedWhole.length());
        res = trimSpace(reversedWhole);
        
        System.out.println("Len: " + res.length());
        return res;
    }
    
    private static String trimSpace2(String s) {
		String res = "";
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') { // character
				res += s.charAt(i);
			} else {
				if (i > 0 && s.charAt(i - 1) != ' ') { // the 1st whitespace 
					res += s.charAt(i);
				} else { // skip repeated whitespace
					continue; 
				}
			}				
		} System.out.println("Res: " + res + ", len: " + res.length());
		
		if (res.equals("")) {
			return res;
		}
		
		if (res.charAt(res.length() - 1) == ' ') {
			return res.substring(0, res.length() - 1);
		} else {
			return res;
		}
	}
    
    public static String reverseWords2(String s) {
        String res = "";
        if (s == " ")
    		return res;
    	
        if (s.length() <= 1)
    		return s;
 
        String tmpRes = trimSpace2(s);
//		System.out.println("tempRes: " + tmpRes + ", len: " + tmpRes.length());

		if (tmpRes.length() <= 1)
    		return tmpRes;
		
        int l = 0, r = tmpRes.length() - 1;
        int start = 0, end =  tmpRes.length() - 1;
        int resStart = 0, resEnd =  tmpRes.length() - 1;
        char[] resChar = new char[tmpRes.length()];
        
        while (l < r) {
        	String headStr = "", tailStr = "";
        	for (; l < tmpRes.length(); l++) {
        	    if (tmpRes.charAt(l) == ' ') {
        	    	if (l == 0 || tmpRes.charAt(l - 1) == ' ') { // 1st or consecutive spaces
        	    		continue;
        	    	} else { // end of head string
        	    		headStr = tmpRes.substring(start, l);             	    
        	    		break;
        	    	}
        	    } else if (l == 0 || tmpRes.charAt(l - 1) == ' ') {
        	    	start = l;
        	    }
        	}
        	for (; r >= 0; r--) {
        		if (tmpRes.charAt(r) == ' ') {
        	    	if (r == tmpRes.length() - 1 || tmpRes.charAt(r + 1) == ' ') { // last or consecutive spaces
        	    		continue;
        	    	} else { //head of end string
        	    		if (end == tmpRes.length() - 1) {
        	    			tailStr = tmpRes.substring(r + 1);
        	    		} else {
        	    			tailStr = tmpRes.substring(r + 1, end + 1);             	            	    			
        	    		}
        	    		break;
        	    	}
        	    } else if (r == (tmpRes.length() - 1) || tmpRes.charAt(r + 1) == ' ') {
        	    	end = r;
        	    }
        	}
        	
//        	System.out.println(headStr + ", " + start + ", " + l + ", " + resStart);
//        	System.out.println(tailStr + ", " + r + ", " + end + ", " + resEnd);
        	for (int i = 0; i < tailStr.length(); i++) {
        		resChar[resStart++] = tailStr.charAt(i);
        	}
        	if (resStart < tmpRes.length() - 1) {
        		resChar[resStart++] = ' ';
        	}
        	if (start == r) { // head and tail strings are the identical one
        		return new String(resChar);
        	} else {
	        	for (int i = headStr.length() - 1; i >= 0; i--) {
	        		resChar[resEnd--] = headStr.charAt(i);
	        	}
	        	if (resEnd >= 0) {
	        		resChar[resEnd--] = ' ';
	        	}
        	}        	
        	
        	start = l + 1;
        	end = r - 1;
        	l++;
        	r--;
        }
        
		return new String(resChar);
    }

    private static Stack<String> trimSpace3(String s) {
    	Stack<String> st = new Stack<String>();
		int start = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') { // character
				if (i > 0 && s.charAt(i - 1) == ' ') { // start of new word
					start = i;
				}
			} else { // space
				if (i > 0 && s.charAt(i - 1) != ' ') { // the 1st whitespace after word 
					st.push(s.substring(start, i));
					start = i + 1;
				} else { // skip repeated whitespace
					start = i + 1;
					continue; 
				}
			}				
		} 
		
		if (start < s.length()) { // last word
			st.push(s.substring(start));
		}
		
		return st;
	}
    
    public static String reverseWords3(String s) {
        String res = "";
        if (s.equals(" "))
    		return res;
    	
        if (s.length() <= 1)
    		return s;
 
        Stack<String> st = trimSpace3(s);

        if (st.size() == 0) {
        	return res;
        }
       
        while (!st.isEmpty()) { // reverse words
        	res += (st.pop() + " ");
        }
        
        if (!res.isEmpty()) {
        	return res.substring(0, res.length() - 1); // trim last space
        } else {
        	return res;
        }
    }
    
    public static void main(String[] args) {
    	 String s = "the sky is blue";
    	 String s2 = " 1";
    	 String s3 = "1 ";
    	 String s4 = "   a   b ";
    	 String s5 = "    ";
    	 System.out.println("Test case 1 in algorithm 1: ");
    	 System.out.println("Before reverse: " + s);
    	 System.out.println("After reverse: " + reverseWords(s));
    	 
    	 System.out.println("Test case 2 in algorithm 1: ");
    	 System.out.println("Before reverse: " + s2);
    	 System.out.println("After reverse: " + reverseWords(s2));
    	 
    	 System.out.println("Test case 3 in algorithm 1: ");
    	 System.out.println("Before reverse: " + s3);
    	 System.out.println("After reverse: " + reverseWords(s3));
    	 
    	 System.out.println("Test case 4 in algorithm 1: ");
    	 System.out.println("Before reverse: " + s4);
    	 System.out.println("After reverse: " + reverseWords(s4));
    	 
    	 System.out.println("Test case 1 in algorithm 2: ");
    	 System.out.println("Before reverse: " + s);
    	 System.out.println("After reverse: " + reverseWords2(s));
    	 
    	 System.out.println("Test case 2 in algorithm 2: ");
    	 System.out.println("Before reverse: " + s2);
    	 System.out.println("After reverse: " + reverseWords2(s2));
    	 
    	 System.out.println("Test case 3 in algorithm 2: ");
    	 System.out.println("Before reverse: " + s3);
    	 System.out.println("After reverse: " + reverseWords2(s3));
    	 
    	 System.out.println("Test case 4 in algorithm 2: ");
    	 System.out.println("Before reverse: " + s4);
    	 System.out.println("After reverse: " + reverseWords2(s4));
    	 
    	 System.out.println("Test case 5 in algorithm 2: ");
    	 System.out.println("Before reverse: " + s5);
    	 System.out.println("After reverse: " + reverseWords2(s5));
    	 
    	 System.out.println("Test case 1 in algorithm 3: ");
    	 System.out.println("Before reverse: " + s);
    	 System.out.println("After reverse: " + reverseWords3(s));
    	 
    	 System.out.println("Test case 2 in algorithm 3: ");
    	 System.out.println("Before reverse: " + s2);
    	 System.out.println("After reverse: " + reverseWords3(s2));
    	 
    	 System.out.println("Test case 3 in algorithm 3: ");
    	 System.out.println("Before reverse: " + s3);
    	 System.out.println("After reverse: " + reverseWords3(s3));
    	 
    	 System.out.println("Test case 4 in algorithm 3: ");
    	 System.out.println("Before reverse: " + s4);
    	 System.out.println("After reverse: " + reverseWords3(s4));
    	 
    	 System.out.println("Test case 5 in algorithm 3: ");
    	 System.out.println("Before reverse: " + s5);
    	 System.out.println("After reverse: " + reverseWords3(s5));
    }
}
