package JPL.ch22.ex22_05;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SaikoroTest {

	@Test
	public void test() {
		int n = 3;
		Saikoro sai = new Saikoro();
		Map<Integer,Integer> map = sai.play(n);
		Set<Integer> s = map.keySet();
		Map<Integer,Integer> map2 = sai.notPlay(n);
		double pow = Math.pow(6, n);
		for(Integer i : s){
			System.out.println(i + ":" + map.get(i) /100000.0 + " 理論:" + map2.get(i)/pow);
		}
	}

}
