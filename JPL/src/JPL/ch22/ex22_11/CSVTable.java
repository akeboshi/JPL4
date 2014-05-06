package JPL.ch22.ex22_11;

import static java.io.StreamTokenizer.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CSVTable {
	public static List<String[]> readCSVTable(Reader source, int n)
			throws IOException, IllegalArgumentException {
		if (n < 1)
			throw new IllegalArgumentException();
		StreamTokenizer in = new StreamTokenizer(source);
		in.ordinaryChars(',', ',');
		in.eolIsSignificant(true);
		List<String[]> list = new ArrayList<>();
		String[] strs = new String[n];
		int i = 0;
		while (in.nextToken() != TT_EOF){
			if(in.ttype == TT_WORD){
				strs[i] = in.sval;
				i++;
			}else if(in.ttype == TT_EOL){
				i=0;
				list.add(strs);
				strs = new String[n];
			}
		}
			return list;
	}
}