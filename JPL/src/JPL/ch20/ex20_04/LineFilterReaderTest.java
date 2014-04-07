package JPL.ch20.ex20_04;

import static org.junit.Assert.*;

import java.io.CharArrayReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class LineFilterReaderTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String input = "foo\nvar";
		String[] inputA = input.split("\n");
		
		CharArrayReader car = new CharArrayReader(input.toCharArray());
		LineFilterReader lfr = new LineFilterReader(car);
		try {
			for(int i = 0 ; i < 2 ; i++){
				int[] res = lfr.readLine();
				for(int ii = 0 ; ii < res.length ; ii++){
					assertEquals(inputA[i].charAt(ii), res[ii]);
				}
			}
			assertEquals(lfr.read(), -1);
		} catch (IOException e) {
			fail();
		}
	}

}
