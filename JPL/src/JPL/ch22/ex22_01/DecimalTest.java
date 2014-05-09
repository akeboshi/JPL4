package JPL.ch22.ex22_01;

import org.junit.Test;

public class DecimalTest {

	@Test
	public void test() {
		Decimal d = new Decimal();
		double[] data = {3.14,8003.1464352104,9120.31415778746531,486313.15441534,531533.1463565};
		System.out.println(d.print(data, 80));
	}

}
