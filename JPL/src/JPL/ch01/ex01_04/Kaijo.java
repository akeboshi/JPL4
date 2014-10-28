package JPL.ch01.ex01_04;

class Kaijo {
	public static void main(String[] args) {
		int num=1;
		int sum=1;
		while( sum < 100000 ) {
			System.out.println(sum);
			sum = num * sum;
			num = num + 1;
		}
	}
}
