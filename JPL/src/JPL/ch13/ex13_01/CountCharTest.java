package JPL.ch13.ex13_01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class CountCharTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CountChar counterChar = new CountChar();
		String input = "aaaiopujnaihnk;aew8";
		char c = 'a';
		int charNum = counterChar.countChar(input, c);
		System.out.println( c + " contained in " + input + " is "+ charNum);
		assertEquals(5, charNum);
	}

}
