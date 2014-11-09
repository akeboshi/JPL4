package JPL.ch22.ex22_08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	@Test
	public void tes2() {
		String path = new File("").getAbsolutePath()
				+ "/src/JPL/ch22/ex22_08/test2.csv";
		try {
			CSVTable.readCSVTable(new FileReader(path), 3);
		} catch (IllegalArgumentException e) {
			fail("exception error");
		} catch (FileNotFoundException e) {
			fail("exception error");
		} catch (IOException e) {
			assertThat(e, instanceOf(IOException.class));
			assertEquals("input format error",e.getMessage());
		}

	}

}
