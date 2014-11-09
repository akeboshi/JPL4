package JPL.ch20.ex20_06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;

class Culc {
	private HashMap<String, Double> val = new HashMap<>();

	public Culc(){
		val.put("foo", 0.0);
		val.put("bar", 0.0);
		val.put("hoge", 0.0);
	}

	public void culc(Reader source) throws IOException{
		StreamTokenizer in = new StreamTokenizer(source);



		String key;
		String op;
			while (in.nextToken() != StreamTokenizer.TT_EOF) {
 				if (in.sval.equals("foo") ||in.sval.equals("bar")|| in.sval.equals("hoge")){
					key = in.sval;
				} else {
					throw new IllegalArgumentException();
				}

 				in.wordChars('+','+');
 				in.wordChars('=', '=');
 				in.ordinaryChar('-');
 				in.wordChars('-', '-');
				in.nextToken();
				if (in.sval.equals("+") || in.sval.equals("-") || in.sval.equals("=")){
					op = in.sval;
				} else {
					throw new IllegalArgumentException();
				}

				in.parseNumbers();
				if (in.nextToken() != StreamTokenizer.TT_NUMBER) {
					throw new IllegalArgumentException("valueは数値を指定してください");
				}

				if (op.equals("+")){
					val.put(key, val.get(key) + in.nval);
				} else if (op.equals("-")){
					val.put(key, val.get(key) - in.nval);
				} else if (op.equals("=")){
					val.put(key, in.nval);
				}
			}
	}

	public Double getVal(String key){
		return val.get(key);
	}
}