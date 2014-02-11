package JPL.ch09.ex09_02;

class CountBit{
	public static void main(String[] args) {
		CountBit countBit = new CountBit();
		for(int i=0 ; i< Integer.MAX_VALUE ; i++){
			if(countBit.bitCountMethod(i) != countBit.integerBitCount(i)){
				System.out.println("error " + i);
			}
		}
		System.out.println(countBit.bitCountMethod(8));
		System.out.println(countBit.integerBitCount(8));
	}

	public int bitCountMethod(int countableData){
		int result = 0;
		while(countableData > 0){
			result += 0x1 & countableData;
			countableData >>= 1;
		}
		return result;
	}

	public int integerBitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}