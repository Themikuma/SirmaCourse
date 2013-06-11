package com.sirma.itt.javacourse.threads.synchronizedthreads;

/**
 * Counts until a user input is provided.
 * 
 * @author gdimitrov
 */
public class Counter implements Runnable {

	private int current;
	private int max;
	private static volatile boolean run;
	private static Object lock;

	/**
	 * Sets the starting to count from and the maximum to count to.
	 * 
	 * @param start
	 *            the starting number to count from.
	 * @param max
	 *            the maximum number to count to.
	 */
	public Counter(int start, int max) {
		this.max = max;
		current = start;
		run = true;
		lock = new Object();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (current < max && run) {
			try {
				current++;
				System.out.println(Thread.currentThread().getName() + " - " + current);
				synchronized (lock) {
					lock.notifyAll();
					lock.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	/**
	 * Getter method for current.
	 * 
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * Setter method for run.
	 * 
	 * @param run
	 *            the run to set
	 */
	public static void setRun(boolean run) {
		Counter.run = run;
	}

}
