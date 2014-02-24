package JPL.ch14.ex14_05;

class StaticMinusObject implements Runnable {
	private static int val;

	public StaticMinusObject(int defVal) {
		StaticMinusObject.val = defVal;
	}
	
	public synchronized int getVal(){
		return StaticMinusObject.val;
	}
	
	public synchronized void setVal(int val){
		StaticMinusObject.val = val;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				add(1);
				
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {

		}
	}
	
	public synchronized void add(int val) {
		setVal(getVal() - val);
		System.out.println(getVal() + " : "
				+ Thread.currentThread().getName());
	}

}