package JPL.ch13.ex13_05;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommaTest {

	@Test
	public void test() {
		Comma test = new Comma();
		String testResult;
		testResult = test.addComma("");
		System.out.println(testResult);
		assertEquals("", testResult);

		testResult = test.addComma("1");
		System.out.println(testResult);
		assertEquals("1", testResult);

		testResult = test.addComma("12");
		System.out.println(testResult);
		assertEquals("12", testResult);

		testResult = test.addComma("123");
		System.out.println(testResult);
		assertEquals("123", testResult);

		testResult = test.addComma("1234");
		System.out.println(testResult);
		assertEquals("1,234", testResult);

		testResult = test.addComma("12345");
		System.out.println(testResult);
		assertEquals("12,345", testResult);

		testResult = test.addComma("1234567890");
		System.out.println(testResult);
		assertEquals("1,234,567,890", testResult);
	}

}
