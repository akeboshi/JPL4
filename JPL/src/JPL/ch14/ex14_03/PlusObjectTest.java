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
		Thread[] plusObject = new Thread[5];
		for (int i = 0 ; i<5 ; i++){
			plusObject[i] = new Thread(runnable,"Object" + i);
			plusObject[i].start();
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		assertTrue( 5000 == ((PlusObject)runnable).getVal());
	}

}
