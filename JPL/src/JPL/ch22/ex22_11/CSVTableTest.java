package JPL.ch22.ex22_11;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.junit.Test;

public class CSVTableTest {

	@Test
	public void test() throws Exception {
		String path = new File("").getAbsolutePath()
				+ "/src/JPL/ch22/ex22_08/test.csv";
		List<String[]> list;
		list = CSVTable.readCSVTable(new FileReader(path), 3);
		StringBuilder sb = new StringBuilder();
		for (String[] ss : list) {
			for (String s : ss) {
				sb.append(s);
				System.out.print(s + " ");
			}
			System.out.println();
		}
		assertEquals("abcdefhijjkl", sb.toString());
	}


}
