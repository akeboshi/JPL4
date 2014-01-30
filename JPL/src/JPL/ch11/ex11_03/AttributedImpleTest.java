package JPL.ch11.ex11_03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class AttributedImpleTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		AttributedImpl<Integer> attrString = new AttributedImpl<Integer>();
		attrString.add(new Attr<Integer>("newString1",1));
		Attr<Integer> foo = new Attr<Integer>("newString2",2);
		attrString.add(foo);
		assertEquals(attrString.find("newString2"), foo);
		attrString.remove("newString1");
		assertNull(attrString.find("newString1"));
		
	}

}
