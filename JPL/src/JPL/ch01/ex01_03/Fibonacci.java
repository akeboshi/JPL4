package JPL.ch01.ex01_03;

class Fibonacci {
	public static void main (String[] args){
		int lo = 1;
		int hi = 1;
		System.out.println("fibonacci list");
		System.out.println(lo);
		while ( hi < 50 ) {
			System.out.println(hi);
			hi = hi + lo;
			lo = hi - lo;
		}
	}
}
