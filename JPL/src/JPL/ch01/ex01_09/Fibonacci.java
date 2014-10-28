package JPL.ch01.ex01_09;

class Fibonacci {
	static final int MAX_INDEX = 9;
	public static void main (String[] args){
		int lo = 1;
		int hi = 1;
		int[] arrayFib = new int[MAX_INDEX];
		System.out.println("fibonacci list");
		arrayFib[0] = lo;
		for (int i = 1 ; i < MAX_INDEX ; i++ ) {
			arrayFib[i] = hi;
			hi = hi + lo;
			lo = hi - lo;
		}
		

		for (int i = 0 ; i < MAX_INDEX ; i++) {
			System.out.println( arrayFib[i] );
		}
		
	}
}
