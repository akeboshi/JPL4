package JPL.ch22.ex22_14;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalDelimiterTest {

	@Test
	public void test() {
		String str = "3.14 15.17 5.6 15.48";
		DecimalDelimiter dd = new DecimalDelimiter();
		assertEquals((Double)39.39, dd.sum(str));
	}

}
