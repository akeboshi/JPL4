package JPL.ch22.ex22_06;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Gaussian {
	private static final int NUM = 10000000;
	private static final int WWW = 2000;

	public static void main(String[] args) {
		Random r = new Random();
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < 100000; i++) {
			int num = (int) (r.nextGaussian()*3);
			if (map.get(num) == null)
				map.put(num, 1);
			else
				map.put(num, map.get(num) + 1);
		}
		for(int i : map.keySet()){
			System.out.printf("%5d",map.get(i));
			System.out.printf("%3d",i);
			int val = map.get(i) / WWW;
			for(int j = 0 ; j< val ; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}