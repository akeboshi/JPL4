package JPL.ch14.ex14_03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class PlusObjectTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Runnable runnable = new PlusObject(0);
		Thread plusObject1 = new Thread(runnable, "plusObject1");
		Thread plusObject2 = new Thread(runnable, "plusObject2");
		
		plusObject1.start();
		plusObject2.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		assertTrue( 20 == ((PlusObject)runnable).getVal());
	}

}
