package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Consumes a product if there is one in the warehouse.
 * 
 * @author gdimitrov
 */
public class Consumer implements Runnable {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (Warehouse.getProducts() > 0) {
			Warehouse.removeProduct();
		}
		System.out.println("Out of products.");
	}
}
