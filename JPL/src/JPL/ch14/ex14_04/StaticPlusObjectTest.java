package JPL.ch14.ex14_04;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import JPL.ch14.ex14_04.StaticPlusObject;

public class StaticPlusObjectTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Runnable runnable = new StaticPlusObject(0);
		Thread plusObject1 = new Thread(runnable, "plusObject1");
		Thread plusObject2 = new Thread(runnable, "plusObject2");
		
		plusObject1.start();
		plusObject2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		assertTrue( 20 == ((StaticPlusObject)runnable).getVal());
	}

}
