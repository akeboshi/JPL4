package JPL.ch22.ex22_02;

import java.util.HashSet;
import java.util.Set;

public class WhichChars{
	private Set<Character> set = new HashSet<>();

	public WhichChars(String str){
		for ( int i = 0 ; i < str.length() ; i++){
			set.add(str.charAt(i));
		}
	}

	public String toString(){
		String ret = "";
		for (Character c : set){
			ret += c;
		}
		return ret;
	}
}