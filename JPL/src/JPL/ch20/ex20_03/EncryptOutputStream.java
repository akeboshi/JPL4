package JPL.ch20.ex20_03;


import java.io.*;

public class EncryptOutputStream extends FilterOutputStream {
	private OutputStream out;
	private byte pattern = 0xf;

	public EncryptOutputStream(OutputStream out) {
		super(out);
		this.out = out;
	}
	
	public EncryptOutputStream(OutputStream out,byte pattern) {
		super(out);
		this.out = out;
		this.pattern = pattern;
	}

	@Override
	public void write(int b) throws IOException {
		byte[] bb = new byte[1];
		bb[0] = (byte) b;
		write(bb);
	}

	@Override
	public void write(byte[] b) throws IOException {
		write(b,0,b.length);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		for (int i = off; i < off + len; i++) {
			out.write(b[i] ^ pattern);
		}
	}
}
