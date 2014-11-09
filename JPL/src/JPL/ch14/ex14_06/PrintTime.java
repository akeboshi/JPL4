package JPL.ch14.ex14_06;

class PrintTime implements Runnable {
	static long passTime = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (;;) {
				try {
					wait(1000);
					passTime += 1000;
					notifyAll();
					System.out.println(passTime / 1000 + "秒");
				} catch (InterruptedException e) {

				}
			}
		}
	}
}

class ShowMessage implements Runnable {
	long defTime;
	String message;
	int countTime = 0;
	Runnable lockObj;

	ShowMessage(long time, String message, Runnable lockObj) {
		this.defTime = time + 1;
		this.message = message;
		this.lockObj = lockObj;
	}

	@Override
	public void run() {
		synchronized (lockObj) {
			for (;;) {
				countTime++;
				if (countTime % defTime != 0) {
					try {
						lockObj.wait();
					} catch (InterruptedException e) {

					}
				} else {
					System.out.println(message);
				}
			}
		}
	}
}
