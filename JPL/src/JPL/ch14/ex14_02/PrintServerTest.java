package JPL.ch14.ex14_02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class PrintServerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		PrintServer ps = new PrintServer();
		assert(ps.test.equals("OK"));
	}

}
