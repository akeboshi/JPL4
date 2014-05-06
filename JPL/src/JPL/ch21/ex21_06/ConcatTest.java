package JPL.ch21.ex21_06;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ConcatTest {

	@Test
	public void test() throws IOException {
		String path = new File("").getAbsolutePath() + "/src/JPL/ch21/ex21_06/";
		String[] files = {path + "test1.txt",path + "test2.txt",path + "test3.txt",};

		Concat.concat(files);

		assertEquals("test1test2test3", Concat.sb.toString());
	}

}
