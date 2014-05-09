package JPL.ch22.ex22_15;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReversePorandCaseTest {

	@Test
	public void test() {
		assertEquals((Double)5.0, ReversePorandCase.calc("3 2 +"));
		assertEquals((Double)(6.0/20.0), ReversePorandCase.calc("3 2 * 4 5 * /"));
		assertEquals((Double)1024.0, ReversePorandCase.calc("2 10 pow"));
	}

}
