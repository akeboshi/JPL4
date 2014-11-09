package JPL.ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CountLine{

	static public Process useCmd(String cmd) throws IOException{
		Process proc = new ProcessBuilder(cmd).redirectErrorStream(true).start();

		InputStream is = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		int i = 0;
		while((line = br.readLine()) != null){
			System.out.printf("%3d: ", i++);
			System.out.println(line);
		}

		return proc;
	}
}