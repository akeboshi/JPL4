package JPL.ch13.ex13_02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class CountStringTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CountString countString = new CountString();
		String target = "aaa iii uuu aaa iii aaa eee";
		String input = "aaa";
		int stringNum = countString.countString(target, input);
		System.out.println( input + " contained in " + target + " is "+ stringNum);
		assertEquals(3, stringNum);
	}

}
