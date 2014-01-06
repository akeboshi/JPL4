package JPL.ch10.ex10_02;

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
			switch (c) {
			case '\n':
				resultString += "\\n";
				break;
			case '\t':
				resultString += "\\t";
				break;
			case '\b':
				resultString += "\\b";
				break;
			case '\r':
				resultString += "\\r";
				break;
			case '\f':
				resultString += "\\f";
				break;
			case '\\':
				resultString += "\\\\";
				break;
			case '\'':
				resultString += "\\\'";
				break;
			case '\"':
				resultString += "\\\"";
				break;
			default:
				resultString += c;
				break;
			}
		}
		return resultString;
	}
}