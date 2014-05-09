package JPL.ch21.ex21_01;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import JPL.ch20.ex20_04.LineFilterReader;

public class SotrList {
	LineFilterReader lfr;
	String filename;

	public SotrList(String filename) {
		this.filename = filename;
	}

	public List<String> readFile() {
		File file = new File(filename);
		List<String> sorted = new ArrayList<String>();
		try {
			lfr = new LineFilterReader(new FileReader(file));
			int[] test;
			while ((test = lfr.readLine()) != null) {
				char[] test2 = new char[test.length-1];
				int i;
				for (i = 0; i < test.length-1; i++)
					test2[i] = (char) test[i];
				sorted.add(String.valueOf(test2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(sorted);
		return sorted;
	}
}
