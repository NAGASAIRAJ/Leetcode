
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
    
    public static String reverseWords2(String s) {
        String res = "";
        if (s == " ")
    		return res;
    	
        if (s.length() <= 1)
    		return s;
        int l = 0, r = s.length() - 1;
        int start = 0, end =  s.length() - 1;
        int resStart = 0, resEnd =  s.length() - 1;
        char[] resChar = new char[s.length()];
        
        while (l < r) {
        	String headStr = "", tailStr = "";
        	for (; l < s.length(); l++) {
        	    if (s.charAt(l) == ' ') {
        	    	if (l == 0 || s.charAt(l - 1) == ' ') { // 1st or consecutive spaces
        	    		continue;
        	    	} else { // end of head string
        	    		headStr = s.substring(start, l);            	    
        	    		break;
        	    	}
        	    } else if (l == 0 || s.charAt(l - 1) == ' ') {
        	    	start = l;
        	    }
        	}
        	for (; r >= 0; r--) {
        		if (s.charAt(r) == ' ') {
        	    	if (r == s.length() - 1 || s.charAt(r + 1) == ' ') { // last or consecutive spaces
        	    		continue;
        	    	} else { //head of end string
        	    		tailStr = s.substring(r + 1, end);            	    
        	    		break;
        	    	}
        	    } else if (r == (s.length() - 1) || s.charAt(r + 1) == ' ') {
        	    	end = r;
        	    }
        	}
        	
        	for (int i = 0, j = start; i <= (end - r); i++) {
        		resChar[j++] = tailStr.charAt(i);
        	}
        	if (start == r) { // head and tail strings are the identical one
        		return new String(resChar);
        	} else {
	        	for (int i = l, j = end; i >= start; i--) {
	        		resChar[j--] = headStr.charAt(i);
	        	}
        	}        	
        	
        	start = l + 1;
        	end = r - 1;
        	l++;
        	r--;
        }
        
		return new String(resChar);
    }
    
    public static void main(String[] args) {
    	 String s = "the sky is blue";
    	 String s2 = " 1";
    	 String s3 = "1 ";
    	 String s4 = "   a   b ";
    	 System.out.println("Test case 1: ");
    	 System.out.println("Before reverse: " + s);
    	 System.out.println("After reverse: " + reverseWords(s));
    	 
    	 System.out.println("Test case 2: ");
    	 System.out.println("Before reverse: " + s2);
    	 System.out.println("After reverse: " + reverseWords(s2));
    	 
    	 System.out.println("Test case 3: ");
    	 System.out.println("Before reverse: " + s3);
    	 System.out.println("After reverse: " + reverseWords(s3));
    	 
    	 System.out.println("Test case 4: ");
    	 System.out.println("Before reverse: " + s4);
    	 System.out.println("After reverse: " + reverseWords(s4));
    	 
    	 System.out.println("Test case 1: ");
    	 System.out.println("Before reverse: " + s);
    	 System.out.println("After reverse: " + reverseWords2(s));
    }
}
