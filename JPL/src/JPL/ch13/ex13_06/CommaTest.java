package JPL.ch13.ex13_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommaTest {

	@Test
	public void test() {
		Comma test = new Comma();
		String testResult;
		testResult = test.addComma("",3);
		System.out.println(testResult);
		assertEquals("", testResult);

		testResult = test.addComma("1",3);
		System.out.println(testResult);
		assertEquals("1", testResult);

		testResult = test.addComma("12",3);
		System.out.println(testResult);
		assertEquals("12", testResult);

		testResult = test.addComma("123",3);
		System.out.println(testResult);
		assertEquals("123", testResult);

		testResult = test.addComma("1234",3);
		System.out.println(testResult);
		assertEquals("1,234", testResult);

		testResult = test.addComma("12345",3);
		System.out.println(testResult);
		assertEquals("12,345", testResult);

		testResult = test.addComma("1234567890",3);
		System.out.println(testResult);
		assertEquals("1,234,567,890", testResult);

		testResult = test.addComma("",4);
		System.out.println(testResult);
		assertEquals("", testResult);

		testResult = test.addComma("1",4);
		System.out.println(testResult);
		assertEquals("1", testResult);

		testResult = test.addComma("12",4);
		System.out.println(testResult);
		assertEquals("12", testResult);

		testResult = test.addComma("123",4);
		System.out.println(testResult);
		assertEquals("123", testResult);

		testResult = test.addComma("1234",4);
		System.out.println(testResult);
		assertEquals("1234", testResult);

		testResult = test.addComma("12345",4);
		System.out.println(testResult);
		assertEquals("1,2345", testResult);

		testResult = test.addComma("1234567890",4);
		System.out.println(testResult);
		assertEquals("12,3456,7890", testResult);

		testResult = test.addComma("1234567890",0);
		System.out.println(testResult);
		assertEquals("1234567890", testResult);

		testResult = test.addComma("1234567890",-1);
		System.out.println(testResult);
		assertEquals("1234567890", testResult);
	}

}
