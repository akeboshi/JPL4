package JPL.ch23.ex23_03;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ExitCmdTest {

	@Test
	public void test() throws IOException {
		List<String> list = ExitCmd.execCommand(new String[]{"ls","src/JPL/ch23/ex23_03"});
		assertEquals(list.get(0), "ExitCmd.java");
		assertEquals(list.get(1), "ExitCmdTest.java");

		List<String> list2 = ExitCmd.execCommand(new String[]{"cat","src/JPL/ch23/ex23_03/ExitCmd.java"});
		assertEquals("public class ExitCmd {", list2.get(9));
		try{
			assertNull(list2.get(10));
			fail();
		} catch (IndexOutOfBoundsException e){

		}
	}

}
