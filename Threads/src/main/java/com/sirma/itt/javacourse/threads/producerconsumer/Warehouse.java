package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * @author gdimitrov
 */
public class Warehouse {

	private int products;
	private final int maxProducts;

	/**
	 * Creates a warehouse that can store a given number of products.
	 * 
	 * @param maxProducts
	 *            the maximum amount of products to be stored.
	 */
	public Warehouse(int maxProducts) {
		this.maxProducts = maxProducts;
	}

	/**
	 * Getter method for products.
	 * 
	 * @return the products
	 */
	public int getProducts() {
		return products;
	}

	/**
	 * Adds a product to the warehouse.
	 */
	public synchronized void addProduct() {
		if (products >= maxProducts) {
			try {
				System.out.println("Producer is waiting for consumption");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		products++;
		System.out.println(Thread.currentThread().getName() + " created a product " + products
				+ " remaining");
		if (products > 10 && products < maxProducts) {
			notifyAll();
		}
	}

	/**
	 * Consumes a product from the warehouse.
	 */
	public synchronized void removeProduct() {
		if (products <= 0) {
			try {
				System.out.println("Consumer is waiting for production");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		products--;
		System.out.println(Thread.currentThread().getName() + " took a product " + products
				+ " remaining");
		if (products < maxProducts - 10 && products > 10) {
			notifyAll();
		}
	}

}
