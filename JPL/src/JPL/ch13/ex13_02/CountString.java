package JPL.ch13.ex13_02;

class CountString{
	public int countString(String target, String input){
		String bufTarget = target.replaceAll(input,"");
		int counter = (target.length() - bufTarget.length())/input.length();
		return counter;
	}
}