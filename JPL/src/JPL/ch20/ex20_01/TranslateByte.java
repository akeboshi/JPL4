package JPL.ch20.ex20_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {
	public static void translate  (InputStream in, OutputStream out, byte from, byte to) {
		int b;
		try {
			while((b = in.read()) != -1){
				out.write(b == from ? to : b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		byte from = 't';
		byte to = 'T';

		translate(System.in, System.out, from, to);
	}
}