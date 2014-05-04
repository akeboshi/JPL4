package JPL.ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class LineFilterReader extends FilterReader {

	public LineFilterReader(Reader in) {
		super(in);
	}

	public int[] readLine() throws IOException{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i;
		while ((i = read()) != -1 && i != '\n') {
			list.add(i);
		}
		if(i == -1) return null;
		int[] ret = new int[list.size()];
		for(int ii = 0 ; ii < list.size() ; ii++)
			ret[ii] = list.get(ii);
		return ret;
	}
}