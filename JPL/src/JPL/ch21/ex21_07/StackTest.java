package JPL.ch21.ex21_07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() {
		Stack<String> stack = new Stack<>();
		assertEquals(true, stack.empty());
		assertEquals("a", stack.push("a"));
		assertEquals(false, stack.empty());

		stack.push("b");
		stack.push("c");

		assertEquals(-1, stack.search("e"));
		assertEquals(1, stack.search("c"));
		assertEquals(3, stack.search("a"));

		assertEquals("c", stack.peek());
		assertEquals("c", stack.pop());
		assertEquals("b", stack.pop());
		assertEquals("a", stack.pop());

		try {
			stack.pop();
			fail("Exception error");
		} catch (Exception e){
			assertThat(e, instanceOf(EmptyStackException.class));
		}

		try {
			stack.peek();
			fail("Exception error");
		} catch (Exception e){
			assertThat(e, instanceOf(EmptyStackException.class));
		}
	}

}
