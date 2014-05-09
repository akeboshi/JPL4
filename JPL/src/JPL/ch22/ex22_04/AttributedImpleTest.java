package JPL.ch22.ex22_04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		List<Object> list = new ArrayList<>();
		list.add("add :newString1='1'");
		list.add("add :newString2='2'");
		list.add("remove :newString1");
		AttributedEye<Integer> eye = new AttributedEye<>(attrString);
		attrString.add(new Attr<Integer>("newString1", 1));
		Attr<Integer> foo = new Attr<Integer>("newString2", 2);
		attrString.add(foo);
		assertEquals(attrString.find("newString2"), foo);
		attrString.remove("newString1");
		assertNull(attrString.find("newString1"));

		for (int i = 0; i < 3; i++) {
			assertEquals(list.get(i), eye.test.get(i));
		}
	}

}
