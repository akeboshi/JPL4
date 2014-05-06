package JPL.ch22.ex22_05;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Saikoro {
	private static final Integer NUM = 100000;

	public Map<Integer, Integer> play(Integer n) {
		Map<Integer, Integer> map = new TreeMap<>();
		Random r = new Random();
		for (int i = 0; i < NUM; i++) {
			Integer sum = 0;
			for (int j = 0; j < n; j++) {
				sum += r.nextInt(6) + 1;
			}
			if (map.get(sum) == null)
				map.put(sum, 1);
			else
				map.put(sum, map.get(sum) + 1);
		}
		return map;
	}

	public Map<Integer, Integer> notPlay(Integer n) {
		Map<Integer, Integer> map = new TreeMap<>();
		map = subNotPray(map, n, 0);
		return map;
	}

	private Map<Integer, Integer> subNotPray(Map<Integer, Integer> map,
			Integer n, int sum) {
		for (int i = 0; i < 6; i++) {
			int sum2 = sum;
			sum2 += (i + 1);
			if (n == 1) {
				if (map.get(sum2) == null)
					map.put(sum2, 1);
				else
					map.put(sum2, map.get(sum2) + 1);
			} else {
				map = subNotPray(map, n - 1, sum2);
			}
		}
		return map;
	}
}