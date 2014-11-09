package JPL.ch11.ex11_02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class AttrTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Attr<String> attr = new Attr<String>("name", "value");
		assertEquals("value", attr.getValue());
		System.out.println(attr.getValue());
		attr.setValue("value2");
		assertEquals("value2", attr.getValue());
		System.out.println(attr.getValue());
	}

}
