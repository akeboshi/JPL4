package JPL.ch22.ex22_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhichCharsTest {

	@Test
	public void test() {
		String str = new String("aaiiuu");

		WhichChars wc = new WhichChars(str);
		assertEquals(true, wc.toString().contains("a"));
		assertEquals(true, wc.toString().contains("i"));
		assertEquals(true, wc.toString().contains("u"));
		assertEquals(3, wc.toString().length());

	}

}
