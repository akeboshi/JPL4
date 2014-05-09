package JPL.ch22.ex22_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhichByteCharsTest {

	@Test
	public void test() {
		String str = new String("aaiiuu");

		WhichByteChars wc = new WhichByteChars(str);
		assertEquals(true, wc.toString().contains("a"));
		assertEquals(true, wc.toString().contains("i"));
		assertEquals(true, wc.toString().contains("u"));
		assertEquals(3, wc.toString().length());
	}

}
