package JPL.ch09.ex09_02;

class CountBit{
	public static void main(String[] args) {
		System.out.println(bitCountMethod(8));
	}

	static public int bitCountMethod(int countableData){
		int result = 0;
		while(countableData > 0){
			result += 0x1 & countableData;
			countableData >>= 1;
		}
		return result;
	}
}