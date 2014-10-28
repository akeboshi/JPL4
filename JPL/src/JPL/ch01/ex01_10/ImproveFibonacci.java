package JPL.ch01.ex01_10;

class ImproveFibonacci{
	static final int MAX_INDEX = 9;
	static final int END_INDEX = 0;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		fibData[] data = new fibData[MAX_INDEX];
		for(int i=0 ; i < MAX_INDEX ; i++ )data[i] = new fibData();

		data[ 0 ].fibNum = lo;		
		data[ 0 ].mark = "";		

		for ( int i = 2 ; i <= MAX_INDEX ; i++) {
			if ( hi % 2 == 0 ) data[ i-1 ].mark = " *";
			else data[ i-1 ].mark ="";
			data[ i-1 ].fibNum = hi;
			hi = lo + hi;
			lo = hi- lo;
		}

		for ( int i = 0 ; i < MAX_INDEX ; i++ ) {
			System.out.println ( (i+1) + " : " + data[i].fibNum + "  " + data[i].mark);
		}
	}
}

class fibData{
	int fibNum;
	String mark;
} 
