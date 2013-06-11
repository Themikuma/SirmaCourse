package com.sirma.itt.javacourse.threads.synchronizedthreads;

/**
 * @author gdimitrov
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {

	}

	/**
	 * @param args
	 *            array of command-line arguments provided by the user.
	 */
	public static void main(String[] args) {
		Counter firstCounter = new Counter(12, 300);
		Counter secondCounter = new Counter(10, 50);
		Thread t1 = new Thread(firstCounter);
		Thread t2 = new Thread(secondCounter);
		t1.start();
		t2.start();
		while (t1.isAlive() || t2.isAlive()) {

			if (!t1.isAlive()) {
				Counter.setRun(false);
			}
			if (!t2.isAlive()) {
				Counter.setRun(false);
			}
		}

	}

}
