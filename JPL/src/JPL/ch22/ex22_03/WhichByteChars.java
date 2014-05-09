package JPL.ch22.ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class WhichByteChars {
	private Map<Integer, BitSet> map = new HashMap<>();

	public WhichByteChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			BitSet set = map.get(c & 0xFF00);
			if (set == null)
				set = new BitSet();
			set.set(c & 0xFF);
			map.put((c & 0xFF00), set);
		}
	}

	public String toString() {
		String ret = "";
		for (Integer i : map.keySet()) {
			BitSet bs = map.get(i);
			for(int j = bs.nextSetBit(0); j >= 0; j = bs.nextSetBit(j + 1)){
				ret += (char)(i+j);
			}
		}
		return ret;
	}

}