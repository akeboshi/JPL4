package JPL.ch10.ex10_01;

class EscapeSequence2String{
	public static void main(String[] args) {
		String baseString = "\t\b\r\f\\da\'ada\"dadad";
		String resultString = getEscapeSequenceString(baseString);
		System.out.println(resultString);
	}

	static public String getEscapeSequenceString(String data){
		String resultString = "";
		for(int i = 0 ; i < data.length() ; i++){
			char c = data.charAt(i);
			if( c == '\n') resultString += "\\n";
			else if( c == '\t') resultString += "\\t";
			else if( c == '\b') resultString += "\\b";
			else if( c == '\r') resultString += "\\4";
			else if( c == '\f') resultString += "\\f";
			else if( c == '\\') resultString += "\\\\";
			else if( c == '\'') resultString += "\\\'";
			else if( c == '\"') resultString += "\\\"";
			//else if( '\000'<= c && c<= '\377') resultString += "\\t";
			else resultString += c;
		}
		return resultString;
	}
}