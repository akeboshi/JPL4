package JPL.ch01.ex01_12;

class ImproveFibonacci{
	static final int MAX_INDEX = 9;
	static final int END_INDEX = 0;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;
		String strFib;

		System.out.println("1: " + lo);

		for ( int i = MAX_INDEX -2 ; i >= END_INDEX ; i--) {
			if ( hi % 2 == 0 ) mark = " *";
			else mark ="";
			strFib = "" + (MAX_INDEX - i) + ": " + hi + mark;
			System.out.println( strFib );
			hi = lo + hi;
			lo = hi- lo;
		}
	}
}
