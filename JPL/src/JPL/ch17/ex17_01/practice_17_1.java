package JPL.ch17.ex17_01;

public class practice_17_1 {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long start;
		long stop;
		
		String[] s = new String[50000000];
		for (int i = 0 ; i< 50000000; i++){
			s[i] = "testre";
		}
		start = rt.freeMemory();
		
		System.out.println("空きメモリ = " + start);
		s=null;
		rt.gc();

		stop = rt.freeMemory();
		System.out.println("空きメモリ = " + stop);
		System.out.println("ガーベージコレクションが働いたのは = " + (stop-start));
	}
}