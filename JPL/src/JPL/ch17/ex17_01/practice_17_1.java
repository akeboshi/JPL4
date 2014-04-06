package JPL.ch17.ex17_01;

public class practice_17_1 {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String[] s = new String[5000];
		long start;
		long stop;
		start = rt.freeMemory();
		System.out.println("空きメモリ = " + start);

		rt.gc();

		stop = rt.freeMemory();
		System.out.println("空きメモリ = " + stop);
		System.out.println("ガーベージコレクションが働いたのは = " + (stop-start));
	}
}