package JPL.ch21.ex21_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
				char[] test2 = new char[test.length];
				for (int i = 0; i < test.length; i++)
					test2[i] = (char) test[i];
				sorted.add(String.valueOf(test2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(sorted);
		for (String string : sorted) {
			System.out.println(string);
		}
		return sorted;
	}

	public static void main(String[] args) {
		new SotrList("/Users/akari/Programming/test.txt").readFile();
	}
}
