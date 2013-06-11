package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * @author gdimitrov
 */
public class Warehouse {

	private int products;

	/**
	 * Setter method for products.
	 * 
	 * @param products
	 *            the products to set
	 */
	public void setProducts(int products) {
		this.products = products;
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
		products++;
		System.out.println("Created a product " + products + " remaining");
		if (products >= 98) {
			try {
				System.out.println("Producer is waiting for consumption");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (products > 10 && products < 100) {
			notifyAll();
		}
	}

	/**
	 * Consumes a product from the warehouse.
	 */
	public synchronized void removeProduct() {
		products--;
		System.out.println("Took a product " + products + " remaining");
		if (products <= 5) {
			try {
				System.out.println("Consumer is waiting for production");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (products < 90 && products > 10) {
			notifyAll();
		}
	}

}
