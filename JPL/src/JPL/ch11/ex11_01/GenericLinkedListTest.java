package JPL.ch11.ex11_01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class GenericLinkedListTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
				GenericLinkedList<String> testListA = new GenericLinkedList<String>();
				GenericLinkedList<String> testListB = new GenericLinkedList<String>();
				testListA.value = "testA1";
				testListB.value = "testB";
				testListA.nextList = testListB;
				testListB.nextList = null;
				
				assertEquals("testB", testListA.nextList.value);
				System.out.println(testListA.nextList.value);
				assertEquals(null, testListA.nextList.nextList);
				System.out.println(testListA.nextList.nextList);
	}

}
