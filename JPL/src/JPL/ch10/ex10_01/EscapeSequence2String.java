package JPL.ch10.ex10_01;

class EscapeSequence2String{
	public static void main(String[] args) {
		String baseString = "\t\b\r\f\\da\'ada\"dadad";
		String resultString = getEscapeSequenceString(baseString).toString();
		System.out.println(resultString);
	}

	static public StringBuilder getEscapeSequenceString(String data){
		StringBuilder resultString = new StringBuilder();
		for(int i = 0 ; i < data.length() ; i++){
			char c = data.charAt(i);
			if( c == '\n') resultString.append("\\n");
			else if( c == '\t') resultString.append("\\t");
			else if( c == '\b') resultString.append("\\b");
			else if( c == '\r') resultString.append("\\4");
			else if( c == '\f') resultString.append("\\f");
			else if( c == '\\') resultString.append("\\\\");
			else if( c == '\'') resultString.append("\\\'");
			else if( c == '\"') resultString.append("\\\"");
			//else if( '\000'<= c && c<= '\377') resultString += "\\t";
			else resultString.append(c);
		}
		return resultString;
	}
}