package com.sirma.itt.javacourse.threads.producerconsumer;

/**
 * @author gdimitrov
 */
public final class Warehouse {

	/**
	 * Private constructor for utility classes.
	 */
	private Warehouse() {

	}

	private static int products;

	/**
	 * Setter method for products.
	 * 
	 * @param products
	 *            the products to set
	 */
	public static void setProducts(int products) {
		Warehouse.products = products;
	}

	/**
	 * Getter method for products.
	 * 
	 * @return the products
	 */
	public static int getProducts() {
		return products;
	}

	/**
	 * Adds a product to the warehouse.
	 */
	public static void addProduct() {
		products++;
	}

	/**
	 * Consumes a product from the warehouse.
	 */
	public static void removeProduct() {
		products--;
	}

}
