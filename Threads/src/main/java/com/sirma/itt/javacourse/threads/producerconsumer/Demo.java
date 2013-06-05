package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Demonstrates the work of the producers and consumers.
 * 
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
	 *            array of command-line arguments passed to this method by the user.
	 * @throws InterruptedException
	 *             Thrown when the thread is occupied and is interrupted.
	 */
	public static void main(String[] args) throws InterruptedException {
		Warehouse.setProducts(0);
		Thread producerThread = new Thread(new Producer());
		Thread consumerThread = new Thread(new Consumer());
		producerThread.start();
		consumerThread.start();
		while (true) {
			if (Warehouse.getProducts() > 15) {
				consumerThread.run();
			}
			if (Warehouse.getProducts() < 75) {
				producerThread.run();
			}
		}
	}
}
