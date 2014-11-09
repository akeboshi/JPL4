package JPL.ch20.ex20_02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByteFilter extends FilterInputStream {
	private byte from;
	private byte to;
	private InputStream in;

	protected TranslateByteFilter(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
		this.in = in;
	}

	public void translate(InputStream in, OutputStream out, byte from, byte to) {
		int b;
		try {
			while ((b = in.read()) != -1) {
				out.write(b == from ? to : b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int read() throws IOException {
		byte[] b = new byte[1];
		if(read(b, 0, 1) == -1)
			return -1;
		return b[0];
	}

	public int read(byte b[]) throws IOException {
		return read(b, 0, b.length);
	}

	public int read(byte b[], int off, int len) throws IOException {
		int ret = in.read(b, off, len);
		for (int i = off; i < off + len; i++) {
			b[i] = (Byte) (b[i] == from ? to : b[i]);
		}
		return ret;
	}
}