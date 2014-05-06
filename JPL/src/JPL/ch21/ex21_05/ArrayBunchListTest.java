package JPL.ch21.ex21_05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Test;

public class ArrayBunchListTest {

	@Test
	public void test() {
		String[][] arrays = new String[4][];
		String[] array = new String[1];
		String[] array2 = new String[3];
		String[] array3 = new String[0];
		String[] array4 = new String[2];

		array[0] = "a";
		arrays[0] = array;

		array2[0] = "b";
		array2[1] = "c";
		array2[2] = "d";
		arrays[1] = array2;

		arrays[2] = array3;

		array4[0] = "e";
		array4[1] = "f";
		arrays[3] = array4;
		ListIterator<String> i = new ArrayBunchList<String>(arrays)
				.listIterator();

		try {
			i.set("a");
			fail("assert error");
		} catch (IllegalStateException e) {
			assertThat(e, instanceOf(IllegalStateException.class));
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (i.hasNext()) {
			sb.append(i.next());
			sb2.append(i.nextIndex());
		}
		assertEquals("abcdef", sb.toString());
		assertEquals("123456", sb2.toString());

		i.previous();
		i.set("set");
		i.next();

		sb = new StringBuilder();
		sb2 = new StringBuilder();
		while (i.hasPrevious()) {
			sb.append(i.previous());
			sb2.append(i.previousIndex());
		}
		assertEquals("setedcba", sb.toString());
		assertEquals("43210-1", sb2.toString());
	}
}
