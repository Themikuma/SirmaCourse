package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Consumes a product if there is one in the warehouse.
 * 
 * @author gdimitrov
 */
public class Consumer implements Runnable {

	private boolean run;
	private long consumptionTime;
	private Warehouse warehouse;

	/**
	 * Creates a consumer and tells it to start getting products.
	 * 
	 * @param consumptionTime
	 *            the time it takes for one product to be produced in miliseconds.
	 * @param warehouse
	 *            the warehouse to use for consumption.
	 */
	public Consumer(long consumptionTime, Warehouse warehouse) {
		run = true;
		this.consumptionTime = consumptionTime;
		this.warehouse = warehouse;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (run) {
			int previousProducts = warehouse.getProducts();
			warehouse.removeProduct();
			if (previousProducts <= warehouse.getProducts()) {
				consumptionTime = (long) (Math.random() * 3000);
			}
			try {
				Thread.sleep(consumptionTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Stops the consumer from consuming more products.
	 */
	public void stop() {
		run = false;
	}
}
