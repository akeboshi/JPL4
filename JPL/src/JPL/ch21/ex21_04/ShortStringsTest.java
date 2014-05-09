package JPL.ch21.ex21_04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShortStringsTest {

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcde");
		list.add("dd");
		list.add("str");
		list.add("ippo");
		ShortStringsListIterator li = new ShortStringsListIterator(list.listIterator(), 3);
		assertEquals(-1, li.previousIndex());
		assertEquals(0, li.nextIndex());
		assertEquals("a", li.next());
		assertEquals("dd", li.next());
		assertEquals("str", li.next());
		assertEquals("str", li.previous());
		assertEquals("dd", li.previous());
	}

}
