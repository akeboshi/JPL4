package JPL.ch07.ex07_01;

class HelloWorld {
	/**
	 * Unicode文字列に変換する("あ" -> "\u3042")
	 * @param original
	 * @return
	 */
	private static String convertToUnicode(String original)
	{
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < original.length(); i++) {
	        sb.append(String.format("\\u%04X", Character.codePointAt(original, i)));
	    }
	    String unicode = sb.toString();
	    return unicode;
	}

	/**
	 * Unicode文字列から元の文字列に変換する ("\u3042" -> "あ")
	 * @param unicode
	 * @return
	 */
	private static String convertToOiginal(String unicode)
	{
	    String[] codeStrs = unicode.split("\\\\u");
	    int[] codePoints = new int[codeStrs.length - 1]; // 最初が空文字なのでそれを抜かす
	    for (int i = 0; i < codePoints.length; i++) {
	        codePoints[i] = Integer.parseInt(codeStrs[i + 1], 16);
	    }
	    String encodedText = new String(codePoints, 0, codePoints.length);
	    return encodedText;
	}
	
	public static void main(String[] args) {
		String utfHelloWorld = convertToUnicode("Hello World");
		String unicodeHelloWorld = convertToOiginal(
				"\\u0048\\u0065\\u006C\\u006C\\u006F\\u0020\\u0057\\u006F\\u0072\\u006C\\u0064");
		System.out.println(unicodeHelloWorld);
		System.out.println("\u0048\u0065\u006C\u006C\u006F\u0020\u0057\u006F\u0072\u006C\u0064");
		System.out.println("\\u0048\\u0065\\u006C\\u006C\\u006F\\u0020\\u0057\\u006F\\u0072\\u006C\\u0064");
		System.out.println(utfHelloWorld);
	}
	
	
}