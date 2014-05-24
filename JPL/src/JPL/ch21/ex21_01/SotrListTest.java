package JPL.ch21.ex21_01;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SotrListTest {

	@Test
	public void test() {
		String path = System.getProperty("user.dir");
			List<String> list =new SotrList(path + "/src/JPL/ch21/ex21_01/test.txt").readFile();
			for(String s : list)
				System.out.println(s);
				assertEquals("aa", list.get(0));
				assertEquals("bb", list.get(1));
				assertEquals("cc", list.get(2));
				assertEquals("dd", list.get(3));
				assertEquals("ee", list.get(4));
	}

}
