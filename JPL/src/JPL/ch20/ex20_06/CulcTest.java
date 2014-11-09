package JPL.ch20.ex20_06;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class CulcTest {

	@Test
	public void test() throws IOException {
		Culc cu = new Culc();

		cu.culc(new StringReader("foo = 2\nbar + 3\nbar + 3\nhoge - 3\nhoge - -5"));
		assertEquals(cu.getVal("foo"), (Double)2.0);
		assertEquals(cu.getVal("bar"), (Double)6.0);
		assertEquals(cu.getVal("hoge"), (Double)2.0);
	}

}
