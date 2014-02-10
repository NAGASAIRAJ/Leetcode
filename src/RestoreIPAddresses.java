import java.util.ArrayList;


public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> results = new ArrayList<String>();
		if( s.length() == 0 || s == null )
			return results;
		int depth = 0, start = 0;
		String ip = "";
		GenerateIP(s, start, depth, results, ip);
		return results;
    }
	private void GenerateIP(String s, int start, int depth, ArrayList<String> results, 
			                 String ip) {
		if( (s.length() - start) > (4 - depth) * 3 )
			return;
		if( s.length() - start < 4 - depth )
			return;
		if( depth == 4 ) {
			ip = ip.substring(0, ip.length() - 1);
			if( !results.contains(ip) )
				results.add(ip);
			return;
		}
		int num = 0;
		for( int i = start; i < Math.min(start + 3, s.length()); i++ ) {
			num = num * 10 + (s.charAt(i) - '0');
			if( num <= 255 )
				GenerateIP(s, i + 1, depth + 1, results, ip + num + '.');
			if( num == 0 )
				break;
		}
	}
	
	public ArrayList<String> restoreIpAddresses2(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length()<4||s.length()>12) return res;
        dfs(s,"",res,0);
        return res;
    }
    
    public void dfs(String s, String tmp, ArrayList<String> res, int count){
        if (count == 3 && isValid(s)) {
            res.add(tmp + s);
            return;
        }
        for(int i=1; i<4 && i<s.length(); i++){
            String substr = s.substring(0,i);
            if (isValid(substr)){
                dfs(s.substring(i), tmp + substr + '.', res, count+1);
            }
        }
    }
    
    public boolean isValid(String s){
        if (s.charAt(0)=='0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num<=255 && num>0;
    }
}
