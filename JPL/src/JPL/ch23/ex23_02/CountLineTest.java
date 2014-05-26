package JPL.ch23.ex23_02;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CountLineTest {

	@Test
	public void test() throws IOException, InterruptedException {
		assertEquals(0, CountLine.useCmd("ls").waitFor());
	}

}
