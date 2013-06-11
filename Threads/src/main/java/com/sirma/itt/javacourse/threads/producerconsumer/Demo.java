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
		Warehouse warehouse = new Warehouse();
		Producer factoryOne = new Producer(90, warehouse);
		Producer factoryTwo = new Producer(100, warehouse);
		Thread productionOne = new Thread(factoryOne);
		Thread productionTwo = new Thread(factoryTwo);
		Consumer consumerOne = new Consumer(100, warehouse);
		Consumer consumerTwo = new Consumer(60, warehouse);
		Thread consumptionOne = new Thread(consumerOne);
		Thread consumptionTwo = new Thread(consumerTwo);
		productionOne.start();
		productionTwo.start();
		consumptionOne.start();
		consumptionTwo.start();
	}
}
