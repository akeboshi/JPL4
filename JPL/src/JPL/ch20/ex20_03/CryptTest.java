package JPL.ch20.ex20_03;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class CryptTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		byte pattern = 0x8;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		EncryptOutputStream eout = new EncryptOutputStream(out,pattern);
		try {
			eout.write((byte) 't');
			eout.flush();
		} catch (IOException e) {
			fail();
		}
		assertNotEquals((out.toByteArray()[0]),(byte)'t');
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		DecryptInputStream din = new DecryptInputStream(in,pattern);
		try {
			assertEquals(din.read(), (byte) 't');
		} catch (IOException e) {
			fail();
		}
	}

}
