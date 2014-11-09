package JPL.ch16.ex16_03;

/* 結果
 * falseの場合は
 * did did didNot didNot
 * true の場合は
 * did did didNot didNot
 * であったり
 * did didNot did didNot
 * だったりした。
 */

class Babble extends Thread {
	static boolean doYield;
	static int howOften;
	private String word;
	
	Babble(String whatToSay){
		word = whatToSay;
	}
	
	public void run(){
		for (int i = 0; i < howOften ; i++){
			System.out.println(word);
			if (doYield)
				Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);
		
		for (int i = 2; i < args.length ; i++) 
			new Babble(args[i]).start();
	}
}