package JPL.ch13.ex13_01;

class CountChar{
	public int countChar(String input, char c){
		int counter = 0;
		for(int i = 0 ; i < input.length() ; i++){
			if(c == input.charAt(i))counter++;
		}
		return counter;
	}
}