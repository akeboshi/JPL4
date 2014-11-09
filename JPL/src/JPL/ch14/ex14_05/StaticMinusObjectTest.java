package JPL.ch14.ex14_05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;


public class StaticMinusObjectTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Runnable runnable = new StaticMinusObject(20);
		Thread plusObject1 = new Thread(runnable, "minusObject1");
		Thread plusObject2 = new Thread(runnable, "minusObject2");
		
		plusObject1.start();
		plusObject2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		assertTrue( 0 == ((StaticMinusObject)runnable).getVal());
	}

}
