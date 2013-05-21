package com.sirma.itt.javacourse.designpatterns;

import java.util.ArrayList;

/**
 * The class that monitors the available products.
 * 
 * @author gdimitrov
 */
public class Available {

	private ArrayList<Object> availableProducts;

	/**
	 * Instantiates the list of products.
	 */
	public Available() {
		availableProducts = new ArrayList<Object>();
	}

	/**
	 * Adds a new product to the list of available products.
	 * 
	 * @param product
	 *            the product to add.
	 */
	public void addNewProduct(Object product) {
		availableProducts.add(product);
	}

	/**
	 * Sells the given product and removes it from the available list.
	 * 
	 * @param product
	 *            the product to sell.
	 */
	public void sellProduct(Object product) {
		availableProducts.remove(product);
	}
}
