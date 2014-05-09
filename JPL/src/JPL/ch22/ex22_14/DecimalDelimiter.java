package JPL.ch22.ex22_14;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DecimalDelimiter {

	public List<Double> delimiter(String str) {
		List<Double> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			list.add(Double.parseDouble(st.nextToken()));
		}
		return list;
	}

	public Double sum(String str) {
		List<Double> list = delimiter(str);
		Double sum = 0.0;
		for (Double d : list)
			sum += d;
		return sum;
	}
}