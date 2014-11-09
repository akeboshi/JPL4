package JPL.ch22.ex22_13;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class AttributedImpleTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		String path = new File("").getAbsolutePath();
		File file = new File(path + "/src/JPL/ch22/ex22_12/test.txt");
		Attributed<Integer> list = null;
		try {
			list = ReadAttr.readAttr(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("a='1'", list.find("a").toString());
		assertEquals("b='5'", list.find("b").toString());
		assertEquals("c='20'", list.find("c").toString());
		assertEquals("d='55'", list.find("d").toString());

	}

}
