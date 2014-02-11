package JPL.ch07.ex07_03;

class Triangle {
	static final int DEPTH = 12;
	public static void main(String[] args) {
		int [][] data = new int[DEPTH][];
		data = triangle(DEPTH);
		printArray(data);
	}

	static public int[][] triangle(int depth){
		int[][] data = new int[depth][];
		int[] data_ini = {1};
		data[0] = data_ini;
		for(int i = 1 ; i < depth ; i++){
			int[] data2= new int[i+1];
			for(int j = 0 ; j < i+1 ; j++){
				data2[j] = ((j-1)>=0 ? data[i-1][j-1] : 0) + ( j < i ? data[i-1][j] : 0);
			}
			data[i]= data2;
		}
		return data;
	}

	static public void printArray(int[][] data){
		for (int[] is : data) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}