package JPL.ch20.ex20_05;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class FindStringTest {

	@Test
	public void test() throws IOException {
		FindString fs = new FindString();
		ArrayList<String> test = fs.find("test.dat", "test");

		assertEquals(3, test.size());
		assertEquals("1: test1", test.get(0));
		assertEquals("3: test2", test.get(1));
		assertEquals("5: test3", test.get(2));
	}

}
