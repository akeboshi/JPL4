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
		for (int i = 0; i < 1000; i++) {
			add(1);			
		}
	}

	public synchronized void add(int val) {
		this.val += val;
		System.out.println(this.val + " : "
				+ Thread.currentThread().getName());
	}

}