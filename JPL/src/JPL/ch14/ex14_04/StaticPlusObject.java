package JPL.ch14.ex14_04;

class StaticPlusObject implements Runnable {
	private static int val;

	public StaticPlusObject(int defVal) {
		StaticPlusObject.val = defVal;
	}
	
	public synchronized int getVal(){
		return StaticPlusObject.val;
	}
	
	public synchronized void setVal(int val){
		StaticPlusObject.val = val;
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
	
	public static synchronized void add(int val) {
		StaticPlusObject.val += val;
		System.out.println(StaticPlusObject.val + " : "
				+ Thread.currentThread().getName());
	}

}