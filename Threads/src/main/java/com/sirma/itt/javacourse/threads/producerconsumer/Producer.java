package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * Produces products for a warehouse.
 * 
 * @author gdimitrov
 */
public class Producer implements Runnable {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		Warehouse.addProduct();
		Warehouse.addProduct();
		while (Warehouse.getProducts() < 100) {
			Warehouse.addProduct();
		}
		System.out.println("Warehouse is full.");
	}

}
