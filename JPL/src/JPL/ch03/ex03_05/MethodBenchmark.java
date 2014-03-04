package JPL.ch03.ex03_05;

import java.util.*;

class MethodBenchmark extends Benchmark{
	public String stringsplit;
	@Override
	void benchmark(){
		String[] stringArrays;
		stringArrays = stringsplit.split(" |　");
		Arrays.sort(stringArrays);
		
		for (int i = 0; i < stringArrays.length; i++) {
			System.out.println(stringArrays[i]);
		}
	}
	
	public static void main(String[] args) {
		int count = 1000;
		MethodBenchmark methodBenchmark = new MethodBenchmark();
		methodBenchmark.stringsplit = "5 3　7 8";
		long time = methodBenchmark.repeat(count);
		System.out.println(count + " methods in " + time +" nanoseconds");
	}
}