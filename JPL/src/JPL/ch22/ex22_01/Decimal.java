package JPL.ch22.ex22_01;

import java.io.StringWriter;
import java.util.Formatter;

public class Decimal {
	static final int LENGTH = 80;

	public String print(double[] data, int column) {
		String format = "%" + column + ".10f" + "\n";
		StringWriter sw = new StringWriter();
		Formatter formatter = new Formatter(sw);

		for (int i = 0; i < data.length; i++) {
			formatter.format(format, data[i]);
		}
		formatter.close();
		return sw.toString();
	}
}