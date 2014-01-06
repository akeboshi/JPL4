/*
 * whileで書き直さない理由：
 * ループをまわすための変数iを使用するのは、ループ内だけであるため、スコープをループ内にとどめておきたいため。
 * また、for文を用いると、初期化とインクリメントをfor文内で行えるため、可読性が向上する。
 * 
 * do-whileで書き直さない理由：
 * do-whileが生かされるのは、実行回数が1...*の場合に限られると思う。
 * また、必ず実行されてしまうため、実行されないように例外処理を加えなくてはならない。
 */

package JPL.ch10.ex10_04;

class EscapeSequence2String{
	public static void main(String[] args) {
		String baseString = "\t\b\r\f\\da\'ada\"dadad";
		System.out.println(getEscapeSequenceStringVerWhile(baseString));
		System.out.println(getEscapeSequenceStringVerDoWhile(baseString));
	}

	static public String getEscapeSequenceStringVerWhile(String data){
		String resultString = "";
		{
			int i = 0;
			while(i<data.length()){
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
				i++;
			}
		}
		return resultString;
	}
	
	static public String getEscapeSequenceStringVerDoWhile(String data){
		String resultString = "";
		if(data != null){
			int i = 0;
			do{
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
				i++;
			}while(i<data.length());
		}
		return resultString;
	}
}