package JPL.ch01.ex01_02;

class HelloWorld{
	public static int main(String[] args){
		System.out.println("HelloWorld");
		return 0;
	}
}
/*
	System.out.println();			でエラー無し
	System.out.println(args);		[Ljava.lang.String;@f52d950
	System.out.println(HelloWorld);		シンボルを見つけることができません。コンパイルエラー
	static void main(String[] args){	メインメソッドがstaticではありません。実行エラー
						指定しなければpublicになるんじゃないの
	public void main(String[] args){	メインメソッドを見つけることができません。実行エラー
	public static int main(String[] args){	returnが見つかりません。コンパイルエラー
						return 0;を追加すると、メインメソッドvoid型を返す必要があります。実行エラー
*/
