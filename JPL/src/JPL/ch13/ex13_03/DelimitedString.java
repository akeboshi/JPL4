package JPL.ch13.ex13_03;

class DelimitedString {
	public static void main(String[] args) {
		for (String string : DelimitedString.delimitedString(
				"Il a dit> <bonjour!><ooo>", '<', '>')) {
			if(string != null)System.out.println(string);
		}
	}

	public static String[] delimitedString(String from, char start , char end){
		int startPos = from.indexOf(start);
		int endPos = from.indexOf(end);
		String[] resultStrings = new String[10];
		int i= 0;
		while(startPos != -1 && endPos != -1){
			if(startPos < endPos){
			resultStrings[i] = from.substring(startPos+1,endPos );
			i++;
			}
			from = from.substring(endPos+1,from.length());
			startPos = from.indexOf(start);
			endPos = from.indexOf(end);
		}
		return resultStrings;
	}
}