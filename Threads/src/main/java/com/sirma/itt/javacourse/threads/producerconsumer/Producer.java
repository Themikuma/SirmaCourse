package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Produces products for a warehouse.
 * 
 * @author gdimitrov
 */
public class Producer implements Runnable {

	private volatile boolean run;
	private long productionTime;
	private Warehouse warehouse;

	/**
	 * Creates a producer and tells it to start creating products.
	 * 
	 * @param productionTime
	 *            the time it takes for one product to be produced in miliseconds.
	 * @param warehouse
	 *            the warehouse to produce for.
	 */
	public Producer(long productionTime, Warehouse warehouse) {
		run = true;
		this.productionTime = productionTime;
		this.warehouse = warehouse;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (run) {
			int previousProducts = warehouse.getProducts();
			warehouse.addProduct();
			// Checks if the warehouse was full when the last product was produced. If the warehouse
			// was full the producer changes the speed at which it creates products, the point being
			// to better demonstrate the way the solution works.
			if (previousProducts >= warehouse.getProducts()) {
				productionTime = (long) (Math.random() * 3000);
			}
			try {
				Thread.sleep(productionTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Stops the producer from producing more products.
	 */
	public void stop() {
		run = false;
	}
}
