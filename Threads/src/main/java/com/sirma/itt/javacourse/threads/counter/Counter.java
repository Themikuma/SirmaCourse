package com.sirma.itt.javacourse.threads.counter;

/**
 * Counts until a user input is provided.
 * 
 * @author gdimitrov
 */
public class Counter implements Runnable {

	private int current;
	private volatile boolean run;

	/**
	 * Sets the current count to 0.
	 */
	public Counter() {
		current = 0;
		run = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (run) {
			current++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void setRun(boolean run) {
		this.run = run;
	}

}
