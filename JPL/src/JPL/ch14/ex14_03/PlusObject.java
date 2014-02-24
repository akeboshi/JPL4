package JPL.ch14.ex14_03;

class PlusObject implements Runnable {
	private volatile int val;

	public PlusObject(int defVal) {
		this.val = defVal;
	}
	
	public synchronized int getVal(){
		return val;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				add(1);
				System.out.println(val + " : "
						+ Thread.currentThread().getName());
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {

		}
	}

	public synchronized void add(int val) {
		this.val += val;
	}

}