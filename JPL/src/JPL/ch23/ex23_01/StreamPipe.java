package JPL.ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamPipe extends Thread {
	private InputStream in;
	private OutputStream out;

	private StreamPipe(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	static public Process userProg(String cmd) throws IOException{
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	static public Process userProg(String[] cmd) throws IOException{
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	static public void plugTogether(InputStream in,OutputStream out) {
		new StreamPipe(in, out).start();
	}

	static public void plugTogether(OutputStream out,InputStream in) {
		new StreamPipe(in, out).start();
	}

	public void run() {
		try {
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.run();
	}
}