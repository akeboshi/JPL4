package JPL.ch23.ex23_01;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class StreamPipeTest {

	@Test
	public void test() throws IOException, InterruptedException {
		assertEquals(0, StreamPipe.userProg("ls").waitFor());
	}

}
