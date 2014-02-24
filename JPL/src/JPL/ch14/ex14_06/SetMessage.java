package JPL.ch14.ex14_06;


class SetMessage {

	public static void main(String[] args) {
		Runnable ct = new PrintTime();
		Thread tl = new Thread(ct);
		Runnable m = new ShowMessage(15, "buzz",ct);
		Thread tl2 = new Thread(m);
		Runnable m2 = new ShowMessage(7, "fizz",ct);
		Thread tl3 = new Thread(m2);
		tl.start();
		tl2.start();
		tl3.start();
	}
}
