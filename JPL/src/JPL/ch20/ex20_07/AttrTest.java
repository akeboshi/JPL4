package JPL.ch20.ex20_07;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.Test;

public class AttrTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		Attr attr = new Attr("foo", "bar");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		attr.writeStream(new DataOutputStream(baos));

		Attr newAttr = new Attr(new DataInputStream(new ByteArrayInputStream(
				baos.toByteArray())));

		assertEquals(newAttr.getName(), "foo");
		assertEquals(newAttr.getValue(), "bar");
	}

}
