package JPL.ch20.ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

class FindString{
	public ArrayList<String> find(String fileName,String str) throws IOException{
		FileReader fileIn = new FileReader(fileName);
		LineNumberReader in = new LineNumberReader(fileIn);
		ArrayList<String> res = new ArrayList<>();
		String line;
		while((line = in.readLine()) != null){
			if(line.indexOf(str) != -1){
				res.add(in.getLineNumber() + ": " + line);
			}
		}
		return res;
	}
}