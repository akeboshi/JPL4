package JPL.ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {

	private byte pattern = 0xf;

	protected DecryptInputStream(InputStream in) {
		super(in);
	}

	protected DecryptInputStream(InputStream in, byte pattern) {
		super(in);
		this.pattern = pattern;
	}

	@Override
	public int read() throws IOException {
		byte[] b = new byte[1];
		if (read(b, 0, 1) == -1)
			return -1;
		return b[0];
	}

	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int ret = super.read(b, off, len);
		for (int i = off; i < off + len; i++) {
			b[i] = (byte) (b[i] ^ pattern);
		}
		return ret;
	}

}