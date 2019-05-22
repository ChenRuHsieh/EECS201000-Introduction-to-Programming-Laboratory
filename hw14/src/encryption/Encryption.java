package encryption;

import java.util.*;

public class Encryption {
	static Map<Character,Character> encode=new HashMap<Character,Character>();
	static Map<Character,Character> decode=new HashMap<Character,Character>();
	
	public Encryption(){
	    String a = "abcdefghijklmnopqrstuvwxyz*";
	    String b = "veknohzf*iljxdmygbrcswqupta";
	    for(int i = 0; i < a.length(); i++){
	        encode.put(a.charAt(i),b.charAt(i));
	        decode.put(b.charAt(i),a.charAt(i));
	    }
	}
	
	public String encode(String str) {
		String strLower = str.toLowerCase();
		String result = "";
		
		for (int i = 0; i < strLower.length(); i++) {
			if(strLower.charAt(i) == ' ') {
				result = result + encode.get('*');
			}
			else {
				if(encode.get(strLower.charAt(i)) == '*')
					result = result + ' ';
				else
					result = result + encode.get(strLower.charAt(i));
			}
		}
		
		return result;
	}
	
	public String decode(String str) {
		String strLower = str.toLowerCase();
		String result = "";
		
		for (int i = 0; i < strLower.length(); i++) {
			if(strLower.charAt(i) == ' ') {
				result = result + decode.get('*');
			}
			else {
				if(decode.get(strLower.charAt(i)) == '*')
					result = result + ' ';
				else
					result = result + decode.get(strLower.charAt(i));
			}
		}
		
		return result;
	}
}
