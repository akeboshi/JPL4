package JPL.ch20.ex20_10;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class CountWord{
	
	public Map<String,Integer> count(Reader source) throws IOException{
		StreamTokenizer in = new StreamTokenizer(source);
		TreeMap<String,Integer> countedWord = new TreeMap<>();
			int type;
			while ((type = in.nextToken()) != StreamTokenizer.TT_EOF) {
				if (type == StreamTokenizer.TT_WORD){
					if (countedWord.containsKey(in.sval)){
						countedWord.put(in.sval, countedWord.get(in.sval) + 1);
					} else {
						countedWord.put(in.sval, 1);
					}
				}
			}
		return countedWord;
	}
	
	public static void main(String[] args) {
		CountWord cd = new CountWord();
		try {
			Map<String,Integer> map =cd.count(new StringReader("a a a a bbb c d bbb a u o i m"));
			Set<String> set = map.keySet();
			for(String key : set)
				System.out.println(key + " : " + map.get(key));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}