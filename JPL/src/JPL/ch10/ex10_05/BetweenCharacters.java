package JPL.ch10.ex10_05;

class BetweenCharacters {
	public static void main(String[] args) {
		displayBetweenCharacters('a', 'd');
		displayBetweenCharacters('d', 'a');
	}

	public static void displayBetweenCharacters(char firstChar, char lastChar) {
		String displayString = "";
		if (firstChar > lastChar) {
			for( ; firstChar >= lastChar ; firstChar--){
				displayString += firstChar;
			}
		} else {
			for (; firstChar <= lastChar; firstChar++) {
				displayString += firstChar;
			}
		}
		System.out.println(displayString);

	}
}