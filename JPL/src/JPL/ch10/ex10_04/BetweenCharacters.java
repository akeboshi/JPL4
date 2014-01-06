/*
 * while, do-while にする理由：
 * for文で書いた場合に for(;firstChar >= lastChar ; firstChar++) や for( ; firstChar >= lastChar ;)
 * などとなり簡潔に書くことができないため、while文を用いても良い。
 * また、必ず一文字は出力されるため、do-whileを用いても良い。
 * 
 */

package JPL.ch10.ex10_04;

class BetweenCharacters {
	public static void main(String[] args) {
		displayBetweenCharactersVerWhile('a', 'd');
		displayBetweenCharactersVerWhile('d', 'a');
		displayBetweenCharactersVerDoWhile('a', 'd');
		displayBetweenCharactersVerDoWhile('d', 'a');
	}

	public static void displayBetweenCharactersVerWhile(char firstChar, char lastChar) {
		String displayString = "";
		char buf;
		if (firstChar > lastChar) {
			while( firstChar >= lastChar ){
				displayString += firstChar--;
			}
		} else {
			while (firstChar <= lastChar) {
				displayString += firstChar++;
			}
		}
		System.out.println(displayString);
	}
	public static void displayBetweenCharactersVerDoWhile(char firstChar, char lastChar) {
		String displayString = "";
		char buf;
		if (firstChar > lastChar) {
			do{
				displayString += firstChar--;
			}while( firstChar >= lastChar );
		} else {
			do{
				displayString += firstChar++;
			}while (firstChar <= lastChar); 
		}
		System.out.println(displayString);
	}
}