package JPL.ch14.ex14_09;

class PrintThreadGroup implements Runnable{
	ThreadGroup threadGroup;
	
	public PrintThreadGroup(ThreadGroup threadGroup){
		this.threadGroup = threadGroup;
	}
	
	public static void main(String[] args) {
		ThreadGroup grp = new ThreadGroup("G");
		ThreadGroup grpTest = new ThreadGroup(grp,"T");

		Runnable service = new Runnable() {
			public synchronized void run() {
				try {
					wait(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(grp, service, "Thread1").start();
		new Thread(new PrintThreadGroup(grp),"printThread1").start();
	}

	private ThreadGroup getParentGroup(ThreadGroup group) {
		ThreadGroup parentGroup = group.getParent();
		if (parentGroup == null) {
			return group;
		} else {
			return getParentGroup(parentGroup);
		}
	}

	private void printThread(ThreadGroup group) {
		Thread[] threadList = new Thread[group.activeCount() + 100];
		group.enumerate(threadList);
		System.out.println("ThreadGroup "+ group.getName() +" のスレッド一覧");
		for (Thread thread : threadList) {
			if (thread != null)
				System.out.printf("%s ", thread.getName());
		}
		System.out.println();
	}

	private void printKaisou(ThreadGroup group, int kaiso) {
		ThreadGroup[] thrGrpList = new ThreadGroup[group.activeGroupCount() + 100];
		group.enumerate(thrGrpList);
		if (thrGrpList[0] != null) {
			System.out.println(kaiso + "階層 親(" + group.getName() + ")");
			for (ThreadGroup threadGroup : thrGrpList) {
				if (threadGroup != null)
					System.out.printf("%s ", threadGroup.getName());
			}
			System.out.println();
			for (ThreadGroup threadGroup : thrGrpList) {
				if (threadGroup != null)
					printKaisou(threadGroup, kaiso + 1);
			}
		}
	}

	private void print(ThreadGroup group) {
		printThread(group);
		System.out.println("0階層");
		System.out.println(getParentGroup(group).getName());
		printKaisou(getParentGroup(group), 1);
	}

	@Override
	public synchronized void run() {
		for(;;){
			try {
				wait(5000);
				print(threadGroup);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}