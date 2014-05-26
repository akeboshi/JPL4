package JPL.ch23.ex23_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExitCmd {
	private static final String exitString = "exit";

	public static List<String> execCommand(String[] cmd) throws IOException {
		Process proc = new ProcessBuilder(cmd).redirectErrorStream(true)
				.start();

		InputStream is = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// コマンドの出力を読み込む

		String line;
		List<String> list = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			if (line.contains(exitString)) {
				proc.destroy();
				break;
			}
			System.out.println(line);
			list.add(line);
		}
		return list;

	}
}