package JPL.ch20.ex20_02;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

public class TestTranslateByteFilter {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		byte[] test = "test".getBytes();
		byte[] after = "TesT".getBytes();
		InputStream in = new ByteArrayInputStream(test);
		@SuppressWarnings("resource")
		TranslateByteFilter ttbf = new TranslateByteFilter(in, (byte)'t', (byte)'T');
		
		for(int i = 0 ; i < 4 ; i++){
				assertEquals(after[i], (byte)ttbf.read());
		}
		assertEquals(-1, ttbf.read());
	}

}
