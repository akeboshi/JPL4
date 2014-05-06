package JPL.ch22.ex22_08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVTable {
	public static List<String[]> readCSVTable(Readable source, int n)
			throws IOException, IllegalArgumentException {
		if (n < 1)
			throw new IllegalArgumentException();
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<>();
		StringBuilder expBuild = new StringBuilder("^([^,]*)");
		for (int i = 0; i < n -1; i++)
			expBuild.append(",([^,]*)");
		expBuild.append("$");
		String exp = expBuild.toString();
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		try {
			while (in.hasNextLine()) {
				String line = in.findInLine(pat);
				if (line != null) {
					String[] cells = new String[n];
					MatchResult match = in.match();
					for (int i = 0; i < cells.length; ++i)
						cells[i] = match.group(i + 1);
					vals.add(cells);
					in.nextLine();
				} else {
					throw new IOException("input format error");

				}
			}
			IOException ex = in.ioException();
			if (ex != null)
				throw ex;
		} finally {
			in.close();
		}
		return vals;
	}
}