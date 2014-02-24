package JPL.ch14.ex14_02;

class PrintServer implements Runnable {
	static public String test = "NG";
	
	public PrintServer(){
			new Thread(this,"test").start();
	}
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("test"))
		{
			System.out.println("current :" + Thread.currentThread());
			test = "OK";
		}
	}
	
}