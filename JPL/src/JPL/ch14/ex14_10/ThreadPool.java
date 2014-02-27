package JPL.ch14.ex14_10;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 * 
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 * 
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {
	private int queueSize;
	private Thread[] threads;
	private LinkedList<Runnable> queue;
	private ArrayList<Thread> runnableThreadList = new ArrayList<Thread>();
	private boolean startFlag = false;

	/**
	 * Constructs ThreadPool.
	 * 
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 * 
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1)
			throw new IllegalArgumentException();

		this.queueSize = queueSize;
		queue = new LinkedList<Runnable>();

		threads = new Thread[numberOfThreads];

		for (int i = 0; i < numberOfThreads; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					Runnable r;
					while (true) {
						synchronized (ThreadPool.this) {
							while (queue.isEmpty()) {
								try {
									ThreadPool.this.notifyAll();
									ThreadPool.this.wait();
								} catch (InterruptedException ignored) {
								}
							}
							r = (Runnable) queue.removeFirst();
						}
						try {
							Thread t = new Thread(r);
							
							t.start();
							runnableThreadList.add(t);
							try {
								t.join();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							ThreadPool.this.notifyAll();
						} catch (RuntimeException e) {
						}
					}
				}
			});
		}
	}

	/**
	 * Starts threads.
	 * 
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		if (startFlag)
			throw new IllegalStateException();
		else
			startFlag = true;

		for (Thread thread : threads) {
			thread.start();
		}
	}

	/**
	 * Stop all threads and wait for their terminations.
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public synchronized void stop() {

		if (!startFlag)
			throw new IllegalStateException();
		while (!queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!runnableThreadList.isEmpty())
		for (Thread thread : runnableThreadList) {
			try {
				if(thread != null)
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 * 
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {

		if (runnable == null)
			throw new NullPointerException();
		if (!startFlag)
			throw new IllegalStateException();
		queue.add(runnable);
		notifyAll();
	}
}
